package com.fernando.androidtrafficlightdetector.listeners

import android.hardware.usb.UsbDevice
import android.util.Log
import com.fernando.androidtrafficlightdetector.interfaces.IView
import me.aflak.arduino.Arduino
import me.aflak.arduino.ArduinoListener

/**
 * Name: Fernando de Oliveira Santos
 * Date: 19/03/18
 */
class MyArduinoListener(
        private val view: IView,
        private val arduino: Arduino
) : ArduinoListener {

    companion object {
        private const val LOG_TAG = "ArduinoListener"
    }

    override fun onArduinoAttached(device: UsbDevice?) {
        arduino.open(device)
        Log.d(LOG_TAG, "Arduino attached.")
    }

    override fun onArduinoMessage(bytes: ByteArray?) {
        Log.d(LOG_TAG, "Message received: ${bytes?.toString(Charsets.UTF_8)}.")
    }

    override fun onArduinoDetached() {
        Log.d(LOG_TAG, "Arduino detached.")
//        mainActivity.stopProcessing()
    }

    override fun onArduinoOpened() {
        Log.d(LOG_TAG, "Connection stablished.")
//        mainActivity.startProcessing()
    }

    override fun onUsbPermissionDenied() {
        Log.d(LOG_TAG, "USB permission denied.")
        view.showMessage("USB permission required!")
        arduino.reopen()
    }
}