package com.fernando.androidtrafficlightdetector.listeners

import android.util.Log
import com.fernando.androidtrafficlightdetector.TrafficLightProcessing
import com.fernando.androidtrafficlightdetector.enums.ArduinoCommand
import com.fernando.androidtrafficlightdetector.enums.TrafficLightState
import com.fernando.androidtrafficlightdetector.interfaces.IView
import me.aflak.arduino.Arduino
import org.opencv.android.CameraBridgeViewBase
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc

class CvCameraListener(private val view: IView, private val arduino: Arduino) : CvCameraViewListener2 {
    companion object {
        private const val LOG_TAG = "CvCameraListener"
    }

    private val trafficLight = TrafficLightProcessing()

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
            TrafficLightState.RED -> ArduinoCommand.STOP
            TrafficLightState.GREEN -> ArduinoCommand.DRIVE
            TrafficLightState.NONE -> ArduinoCommand.NONE
        }

        if (command != ArduinoCommand.NONE) {
            arduino.send(command.value.toByteArray())
            Log.d(LOG_TAG, "Command sent: ${command.value}")
        }

        processFrameCounter++

        System.gc()

        return finalImg
    }
}
