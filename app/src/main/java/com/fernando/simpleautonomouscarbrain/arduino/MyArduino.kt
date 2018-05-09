package com.fernando.simpleautonomouscarbrain.arduino

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import com.felhr.usbserial.UsbSerialDevice
import com.felhr.usbserial.UsbSerialInterface
import me.aflak.arduino.ArduinoListener

/**
 * Name: Fernando de Oliveira Santos
 * Date: 17/03/18
 */

class MyArduino(private val context: Context) : UsbSerialInterface.UsbReadCallback {
    private var listener: ArduinoListener? = null
    
    private var connection: UsbDeviceConnection? = null
    private var serialPort: UsbSerialDevice? = null
    private var usbReceiver: UsbReceiver? = null
    private var usbManager: UsbManager? = null
    private var lastArduinoAttached: UsbDevice? = null
    
    private var isOpened = false
    
    private val actionUsbDevicePermission = "me.aflak.arduino.USB_PERMISSION"
    private val defaultArduinoVendorId = 0x0403 // 9025
    private val defaultBaudRate = 115200
    
    init {
        usbReceiver = UsbReceiver()
        usbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager
    }
    
    fun setArduinoListener(listener: ArduinoListener?) {
        this.listener = listener
        
        val intentFilter = IntentFilter()
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED)
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED)
        intentFilter.addAction(actionUsbDevicePermission)
        context.registerReceiver(usbReceiver, intentFilter)
        
        lastArduinoAttached = getAttachedArduino()
        if (lastArduinoAttached != null && listener != null) {
            listener.onArduinoAttached(lastArduinoAttached)
        }
    }
    
    fun unsetArduinoListener() {
        listener = null
    }
    
    fun open(device: UsbDevice?) {
        val permissionIntent = PendingIntent.getBroadcast(context, 0,
                Intent(actionUsbDevicePermission), 0)
        val filter = IntentFilter()
        filter.addAction(actionUsbDevicePermission)
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED)
        context.registerReceiver(usbReceiver, filter)
        usbManager!!.requestPermission(device, permissionIntent)
    }
    
    fun reopen() {
        open(lastArduinoAttached)
    }
    
    fun close() {
        if (serialPort != null) {
            serialPort!!.close()
        }
        if (connection != null) {
            connection!!.close()
        }
        
        isOpened = false
        context.unregisterReceiver(usbReceiver)
    }
    
    fun send(command: String) {
        serialPort?.takeIf { isOpened() }.apply { serialPort?.write(command.toByteArray()) }
    }
    
    private inner class UsbReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val device: UsbDevice
            if (intent.action != null) {
                when (intent.action) {
                    UsbManager.ACTION_USB_DEVICE_ATTACHED -> {
                        device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)
                        if (device.vendorId == defaultArduinoVendorId) {
                            lastArduinoAttached = device
                            if (listener != null) {
                                listener!!.onArduinoAttached(device)
                            }
                        }
                    }
                    UsbManager.ACTION_USB_DEVICE_DETACHED -> {
                        device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)
                        if (device.vendorId == defaultArduinoVendorId) {
                            if (listener != null) {
                                listener!!.onArduinoDetached()
                            }
                        }
                    }
                    actionUsbDevicePermission ->
                        if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                            device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)
                            if (device.vendorId == defaultArduinoVendorId) {
                                connection = usbManager!!.openDevice(device)
                                serialPort = UsbSerialDevice.createUsbSerialDevice(device, connection)
                                if (serialPort != null) {
                                    if (serialPort!!.open()) {
                                        serialPort!!.setBaudRate(defaultBaudRate)
                                        serialPort!!.setDataBits(UsbSerialInterface.DATA_BITS_8)
                                        serialPort!!.setStopBits(UsbSerialInterface.STOP_BITS_1)
                                        serialPort!!.setParity(UsbSerialInterface.PARITY_NONE)
                                        serialPort!!.setFlowControl(UsbSerialInterface.FLOW_CONTROL_OFF)
                                        serialPort!!.read(this@MyArduino)
                                        
                                        isOpened = true
                                        
                                        if (listener != null) {
                                            listener!!.onArduinoOpened()
                                        }
                                    }
                                }
                            }
                        } else if (listener != null) {
                            listener!!.onUsbPermissionDenied()
                        }
                }
            }
        }
    }
    
    private fun getAttachedArduino(): UsbDevice? {
        val map = usbManager!!.deviceList
        for (device in map.values) {
            if (device.vendorId == defaultArduinoVendorId) {
                return device
            }
        }
        return null
    }
    
    override fun onReceivedData(bytes: ByteArray) {
        if (listener != null && bytes.isNotEmpty()) {
            listener!!.onArduinoMessage(bytes)
        }
    }
    
    private fun isOpened(): Boolean {
        return isOpened
    }
}