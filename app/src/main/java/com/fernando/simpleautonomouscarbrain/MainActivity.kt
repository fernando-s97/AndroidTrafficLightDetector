package com.fernando.simpleautonomouscarbrain

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import me.aflak.arduino.Arduino
import org.opencv.android.BaseLoaderCallback
import org.opencv.android.CameraBridgeViewBase
import org.opencv.android.LoaderCallbackInterface
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {
    companion object {
        private const val LOG_TAG = "MainActivity"
        private const val CAMERA_PRC = 0 // PRC = Permission Request Code
    }
    
    private lateinit var arduino: Arduino
    private lateinit var javaCameraView: CameraBridgeViewBase
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) check4CameraPermission()
    
        arduino = Arduino(this, 115200)
        
        javaCameraView = findViewById(R.id.javaCameraView)
    }
    
    override fun onStart() {
        super.onStart()
    
        arduino.setArduinoListener(MyArduinoListener(this, arduino, this))
        
        loadOpenCv()
    
        startProcessing() // TODO (Remove later: only arduino can start it)
    }
    
    fun startProcessing() {
        javaCameraView.setCvCameraViewListener(CvCameraListener(this, arduino))
    }
    
    override fun onStop() {
        super.onStop()
        
        arduino.unsetArduinoListener()
    
        stopProcessing()
    }
    
    fun stopProcessing() {
        javaCameraView.disableView()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        
        arduino.close()
    
        stopProcessing()
    }
    
    private fun check4CameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.CAMERA)) {
                Snackbar.make(findViewById(R.id.root), "Camera permission required!!",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction("Try Again") {
                            requestCameraPermission()
                        }
                        .show()
            } else {
                requestCameraPermission()
            }
        }
    }
    
    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PRC)
    }
    
    private fun loadOpenCv() {
        val openCvBaseLoaderCallback = object : BaseLoaderCallback(this) {
            override fun onManagerConnected(status: Int) {
                super.onManagerConnected(status)
                
                if (status == BaseLoaderCallback.SUCCESS) javaCameraView.enableView()
                else super.onManagerConnected(status)
            }
        }
        
        if (OpenCVLoader.initDebug()) {
            openCvBaseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
            Log.i(LOG_TAG, "OpenCV loaded")
        } else {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, openCvBaseLoaderCallback)
            Log.i(LOG_TAG, "Failed to load OpenCV")
        }
    }
}
