package com.simonesummo.samplemqtt.client

import android.content.Context
import com.simonesummo.samplemqtt.client.utils.*
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*

class MQTTClient(
    context: Context?,
    serverURI: String,
    clientID: String = ""
) {
    private var mqttClient = MqttAndroidClient(context, serverURI, clientID)

    fun connect(
        username: String = "",
        password: String = "",
        cbConnect: IMqttActionListener = DefaultConnect,
        cbClient: MqttCallback = DefaultClient
    ) {
        mqttClient.setCallback(cbClient)

        val options = MqttConnectOptions()
        options.userName = username
        options.password = password.toCharArray()

        try {
            mqttClient.connect(options, null, cbConnect)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun subscribe(
        topic: String,
        qos: Int = 1,
        cbSubscribe: IMqttActionListener = DefaultSubscribe
    ) {
        try {
            mqttClient.subscribe(topic, qos, null, cbSubscribe)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun unsubscribe(
        topic: String,
        cbUnsubscribe: IMqttActionListener = DefaultUnsubscribe
    ) {
        try {
            mqttClient.unsubscribe(topic, null, cbUnsubscribe)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun publish(
        topic: String,
        msg: String,
        qos: Int = 1,
        retained: Boolean = false,
        cbPublish: IMqttActionListener = DefaultPublish
    ) {
        try {
            val message = MqttMessage()
            message.payload = msg.toByteArray()
            message.qos = qos
            message.isRetained = retained
            mqttClient.publish(topic, message, null, cbPublish)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun disconnect(cbDisconnect: IMqttActionListener = DefaultDisconnect) {
        try {
            mqttClient.disconnect(null, cbDisconnect)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }
}