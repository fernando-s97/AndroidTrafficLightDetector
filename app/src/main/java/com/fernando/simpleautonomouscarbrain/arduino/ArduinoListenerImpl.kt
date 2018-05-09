package com.fernando.simpleautonomouscarbrain.arduino

import android.hardware.usb.UsbDevice
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.fernando.simpleautonomouscarbrain.MainActivity
import com.fernando.simpleautonomouscarbrain.R
import me.aflak.arduino.ArduinoListener

/**
 * Name: Fernando de Oliveira Santos
 * Date: 19/03/18
 */
class ArduinoListenerImpl(private val activity: AppCompatActivity,
                          private val arduino: MyArduino,
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
        arduino.send(ArduinoListenerImpl.START_PROGRAM_COMMAND)
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