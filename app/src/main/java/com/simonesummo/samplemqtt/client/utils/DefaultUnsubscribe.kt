package com.simonesummo.samplemqtt.client.utils

import android.util.Log
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttToken

object DefaultUnsubscribe : IMqttActionListener {
    override fun onSuccess(asyncActionToken: IMqttToken?) {
        Log.d(this.javaClass.name, "Unsubscribed to topic")
    }

    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
        Log.d(this.javaClass.name, "Failed to unsubscribe topic")
    }
}