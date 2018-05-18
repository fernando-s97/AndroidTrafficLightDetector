package com.fernando.simpleautonomouscarbrain.imageProcessing

import org.opencv.core.Mat

interface ITrafficLightProcessing {
    companion object {
        const val RED = 0
        const val GREEN = 1
        const val NONE = -1
    }
    
    fun getState(srcImg: Mat, filteredImg: Mat): Int
}
