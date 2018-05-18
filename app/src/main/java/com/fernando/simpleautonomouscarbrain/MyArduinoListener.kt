package com.fernando.simpleautonomouscarbrain

import android.hardware.usb.UsbDevice
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import me.aflak.arduino.Arduino
import me.aflak.arduino.ArduinoListener

/**
 * Name: Fernando de Oliveira Santos
 * Date: 19/03/18
 */
class MyArduinoListener(private val activity: AppCompatActivity,
                        private val arduino: Arduino,
                        private val mainActivity: MainActivity) : ArduinoListener {
    companion object {
        private const val LOG_TAG = "ArduinoListener"
        const val START_PROGRAM_COMMAND = "start"
        const val BRAKE_COMMAND = "brake"
        const val DRIVE_COMMAND = "drive"
        const val NONE_COMMAND = ""
    }
    
    override fun onArduinoAttached(device: UsbDevice?) {
        arduino.open(device)
        Log.i(LOG_TAG, "Arduino attached")
    }
    
    override fun onArduinoMessage(bytes: ByteArray?) {
        Log.i(LOG_TAG, "Message received: ${bytes?.toString(Charsets.UTF_8)}")
    }
    
    override fun onArduinoDetached() {
        mainActivity.stopProcessing()
        arduino.unsetArduinoListener()
        Log.i(LOG_TAG, "Arduino detached")
    }
    
    override fun onArduinoOpened() {
        arduino.send(START_PROGRAM_COMMAND.toByteArray())
        mainActivity.startProcessing()
        Log.i(LOG_TAG, "Connection stablished")
    }
    
    override fun onUsbPermissionDenied() {
        Snackbar.make(activity.findViewById<View>(R.id.root), "USB permission required!!",
                Snackbar.LENGTH_INDEFINITE)
                .setAction("Try again") { arduino.reopen() }
                .show()
    }
}