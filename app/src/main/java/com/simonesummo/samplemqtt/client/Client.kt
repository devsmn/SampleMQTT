package com.simonesummo.samplemqtt.client

data class Client(
        var serverURI: String = "",
        var clientID: String = "",
        var username: String = "",
        var password: String = ""
    )