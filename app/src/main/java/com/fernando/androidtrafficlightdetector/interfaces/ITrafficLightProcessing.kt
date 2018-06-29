package com.fernando.androidtrafficlightdetector.interfaces

import com.fernando.androidtrafficlightdetector.enums.TrafficLightState
import org.opencv.core.Mat

interface ITrafficLightProcessing {
    fun getState(srcImg: Mat, filteredImg: Mat): TrafficLightState
}
