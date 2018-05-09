package com.fernando.simpleautonomouscarbrain.imageProcessing

import android.util.Log
import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.core.Scalar
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

/**
 * Name: Fernando de Oliveira Santos
 * Date: 19/03/18
 */

class TrafficLightProcessingImpl : TrafficLightProcessing {
    companion object {
        private const val LOG_TAG = "TrafficLightProcessing"
        private const val MIN_DISTANCE = 5.0
        private const val STOPPED = 0
        private const val DRIVING = 1
    }
    
    private val redFilter = arrayOf(Scalar(0.0, 100.0, 100.0), Scalar(10.0, 255.0, 255.0))
    private val greenFilter = arrayOf(Scalar(50.0, 100.0, 100.0), Scalar(70.0, 255.0, 255.0))
    
    private var carState = DRIVING
    private var thereIsCircle = false
    
    // TODO(Latter add the feature to process only the right half of the image)
    override fun getState(srcImg: Mat, filteredImg: Mat): Int {
        return when (carState) {
            DRIVING -> {
                Log.i(LOG_TAG, "LOOKING for RED sign.")
                return if (findRed(srcImg, filteredImg)) {
                    Log.i(LOG_TAG, "RED signal found!")
                    TrafficLightProcessing.RED
                } else {
                    Log.i(LOG_TAG, "RED signal NOT found!")
                    TrafficLightProcessing.NONE
                }
            }
            STOPPED -> {
                Log.i(LOG_TAG, "LOOKING for GREEN sign.")
                return if (findGreen(srcImg, filteredImg)) {
                    Log.i(LOG_TAG, "GREEN signal found!")
                    TrafficLightProcessing.GREEN
                } else {
                    Log.i(LOG_TAG, "GREEN signal NOT found!")
                    TrafficLightProcessing.NONE
                }
            }
            else -> {
                Log.i(LOG_TAG, "Failed to retrieve car state")
                TrafficLightProcessing.NONE
            }
        }
    }
    
    private fun findRed(srcImg: Mat, dstImg: Mat): Boolean {
        filterColor(srcImg, redFilter, null, dstImg)
        
        if (Core.countNonZero(dstImg) == 0) return false
        
        Log.i(LOG_TAG, "RED found")
        
        thereIsCircle = hasCircle(dstImg)
        if (!thereIsCircle) return false
        Log.i(LOG_TAG, "RED circle found")
        
        carState = STOPPED
        
        return true
    }
    
    private fun findGreen(srcImg: Mat, dstImg: Mat): Boolean {
        filterColor(srcImg, greenFilter, null, dstImg)
        
        if (Core.countNonZero(dstImg) == 0) return false
        
        Log.i(LOG_TAG, "GREEN found")
        
        thereIsCircle = hasCircle(dstImg)
        if (!thereIsCircle) return false
        
        Log.i(LOG_TAG, "GREEN circle found")
        
        carState = DRIVING
        
        return true
    }
    
    private fun filterColor(srcImg: Mat, filter1: Array<Scalar>,
                            filter2: Array<Scalar>?, dstImg: Mat) {
        if (filter2 == null) {
            Core.inRange(srcImg, filter1[0], filter1[1], dstImg)
        } else {
            val lowerImg = Mat()
            val upperImg = Mat()
            
            Core.inRange(srcImg, filter1[0], filter1[1], lowerImg)
            Core.inRange(srcImg, filter2[0], filter2[1], upperImg)
            Core.addWeighted(lowerImg, 1.0, upperImg, 1.0, 0.0, dstImg)
            // TODO(Search difference between addWeighted and bitwise_or)
        }
        
        Imgproc.GaussianBlur(dstImg, dstImg, Size(9.0, 9.0), 2.0, 2.0) // TODO(Search this parameters)
    }
    
    private fun hasCircle(srcImg: Mat): Boolean {
        Log.i(LOG_TAG, "LOOKING for CIRCLES...")
        val circles = Mat(srcImg.width(), srcImg.height(), srcImg.type())
        
        Imgproc.HoughCircles(srcImg, circles, Imgproc.HOUGH_GRADIENT, 1.2, MIN_DISTANCE)
        
        /*
        if (circles.rows() > 0) {
            for (i in 0 until circles.cols()) {
                val properties = circles.get(0, i)
                if (properties.size >= 3) {
                    val center = Point(properties[0], properties[1])
                    val radius = properties[2].toInt()
                    Imgproc.circle(srcImg, center, radius, Scalar(0.0, 255.0, 0.0), 4)
                }
            }
    
            return true
        }
        
        return false
        */
        
        if (circles.rows() > 0) {
            for (i in 0 until circles.cols()) {
                val properties = circles.get(0, i)
                if (properties.size >= 3) return true
            }
        }
        
        return false
    }
}