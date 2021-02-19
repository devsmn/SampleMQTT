package com.simonesummo.samplemqtt.client.utils

import android.util.Log
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

object DefaultClient : MqttCallback {
    override fun connectionLost(cause: Throwable?) {
        Log.d(this.javaClass.name, "Connection lost ${cause.toString()}")
    }

    override fun messageArrived(topic: String?, message: MqttMessage?) {
        Log.d(this.javaClass.name, "Receive message: ${message.toString()} from topic: $topic")
    }

    override fun deliveryComplete(token: IMqttDeliveryToken?) {
        Log.d(this.javaClass.name, "Delivery completed")
    }
}