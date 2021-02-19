package com.simonesummo.samplemqtt.client.utils

import android.util.Log
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttToken

object DefaultPublish : IMqttActionListener {
    override fun onSuccess(asyncActionToken: IMqttToken?) {
        Log.d(this.javaClass.name, "Disconnected")
    }

    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
        Log.d(this.javaClass.name, "Failed to disconnect")
    }
}