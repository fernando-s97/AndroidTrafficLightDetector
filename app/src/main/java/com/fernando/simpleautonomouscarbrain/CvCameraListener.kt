package com.fernando.simpleautonomouscarbrain

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.fernando.simpleautonomouscarbrain.arduino.ArduinoListenerImpl
import com.fernando.simpleautonomouscarbrain.arduino.MyArduino
import com.fernando.simpleautonomouscarbrain.imageProcessing.ITrafficLightProcessing
import com.fernando.simpleautonomouscarbrain.imageProcessing.TrafficLightProcessing
import org.opencv.android.CameraBridgeViewBase
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc

class CvCameraListener(private val activity: Activity,
                       private val arduino: MyArduino) : CvCameraViewListener2 {
    companion object {
        private const val LOG_TAG = "CvCameraListener"
    }
    
    private val trafficLight: ITrafficLightProcessing = TrafficLightProcessing()
    
    private lateinit var rgbaImg: Mat
    private lateinit var hsvImg: Mat
    private lateinit var blurredImg: Mat
    private lateinit var finalImg: Mat
    
    private var processFrameCounter = 0
    
    override fun onCameraViewStarted(width: Int, height: Int) {
        rgbaImg = Mat(height, width, CvType.CV_8UC1)
        hsvImg = Mat(height, width, CvType.CV_8UC1)
        blurredImg = Mat(height, width, CvType.CV_8UC1)
        finalImg = Mat(height, width, CvType.CV_8UC1)
    }
    
    override fun onCameraViewStopped() {
        rgbaImg.release()
        finalImg.release()
        blurredImg.release()
        hsvImg.release()
    }
    
    override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame?): Mat {
        rgbaImg = inputFrame?.rgba()!!
    
        if (processFrameCounter == 2) {
            processFrameCounter = 0
            return this.rgbaImg
        }
        
        Imgproc.medianBlur(rgbaImg, blurredImg, 3)
        
        Imgproc.cvtColor(blurredImg, hsvImg, Imgproc.COLOR_RGB2HSV)
        
        val command = when (trafficLight.getState(hsvImg, finalImg)) {
            ITrafficLightProcessing.RED -> ArduinoListenerImpl.BRAKE_COMMAND
            ITrafficLightProcessing.GREEN -> ArduinoListenerImpl.DRIVE_COMMAND
            else -> ArduinoListenerImpl.NONE_COMMAND
        }
        
        if (command != ArduinoListenerImpl.NONE_COMMAND) {
            activity.runOnUiThread {
                Toast.makeText(activity, "Command: $command", Toast.LENGTH_SHORT).show()
            }
            arduino.send(command)
            Log.i(LOG_TAG, "Command sent: $command")
        }
    
        processFrameCounter++
        
        System.gc()
        
        return finalImg
    }
}
