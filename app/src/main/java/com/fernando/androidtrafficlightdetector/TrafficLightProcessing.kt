package com.fernando.androidtrafficlightdetector

import android.util.Log
import com.fernando.androidtrafficlightdetector.enums.CarState
import com.fernando.androidtrafficlightdetector.enums.TrafficLightState
import com.fernando.androidtrafficlightdetector.interfaces.ITrafficLightProcessing
import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.core.Scalar
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

/**
 * Name: Fernando de Oliveira Santos
 * Date: 19/03/18
 */

class TrafficLightProcessing : ITrafficLightProcessing {
    companion object {
        private const val LOG_TAG = "ITrafficLightProcessing"
        private const val MIN_DISTANCE = 5.0
    }

    private val redFilter = arrayOf(
            Scalar(0.0, 100.0, 100.0),
            Scalar(10.0, 255.0, 255.0)
    )
    private val greenFilter = arrayOf(
            Scalar(50.0, 100.0, 100.0),
            Scalar(70.0, 255.0, 255.0)
    )

    private var carState = CarState.STOPPED
    private var hasCircle = false

    override fun getState(srcImg: Mat, filteredImg: Mat): TrafficLightState {
        when (carState) {
            CarState.DRIVING -> {
                if (findRed(srcImg, filteredImg)) return TrafficLightState.RED
            }

            CarState.STOPPED -> {
                if (findGreen(srcImg, filteredImg)) return TrafficLightState.GREEN
            }
        }

        Log.d(LOG_TAG, "Signal not found!")
        return TrafficLightState.NONE
    }

    private fun filterColor(srcImg: Mat, filter1: Array<Scalar>, filter2: Array<Scalar>?,
                            dstImg: Mat) {
        if (filter2 == null) {
            Core.inRange(srcImg, filter1[0], filter1[1], dstImg)
        } else {
            val lowerImg = Mat()
            val upperImg = Mat()

            Core.inRange(srcImg, filter1[0], filter1[1], lowerImg)
            Core.inRange(srcImg, filter2[0], filter2[1], upperImg)
            // TODO(Search difference between addWeighted and bitwise_or)
            Core.addWeighted(lowerImg, 1.0, upperImg, 1.0, 0.0, dstImg)
        }

        // TODO(Search this parameters)
        Imgproc.GaussianBlur(dstImg, dstImg, Size(9.0, 9.0), 2.0, 2.0)
    }

    private fun findRed(srcImg: Mat, dstImg: Mat): Boolean {
        Log.d(LOG_TAG, "Looking for red sign.")

        filterColor(srcImg, redFilter, null, dstImg)
        if (Core.countNonZero(dstImg) == 0) return false

        Log.d(LOG_TAG, "Red color found.")

        hasCircle = hasCircle(dstImg)
        if (!hasCircle) return false

        Log.d(LOG_TAG, "Red signal found!")

        carState = CarState.STOPPED

        return true
    }

    private fun findGreen(srcImg: Mat, dstImg: Mat): Boolean {
        Log.d(LOG_TAG, "Looking for green sign.")

        filterColor(srcImg, greenFilter, null, dstImg)
        if (Core.countNonZero(dstImg) == 0) return false

        Log.d(LOG_TAG, "Green color found.")

        hasCircle = hasCircle(dstImg)
        if (!hasCircle) return false

        Log.d(LOG_TAG, "Green signal found!")

        carState = CarState.DRIVING

        return true
    }

    private fun hasCircle(srcImg: Mat): Boolean {
        Log.d(LOG_TAG, "Looking for circles.")

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