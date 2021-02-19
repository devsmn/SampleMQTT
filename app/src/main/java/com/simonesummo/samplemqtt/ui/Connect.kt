package com.simonesummo.samplemqtt.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.simonesummo.samplemqtt.client.Client

@Composable
fun Connect() {

    val clientState = remember { mutableStateOf(Client()) }

    Column(Modifier.verticalScroll(rememberScrollState())) {
        TextInput(
            title = "Server URI",
            value = clientState.value.serverURI,
            onValueChange = { clientState.value.serverURI = it }
        )

        TextInput(
            title = "Client ID",
            value = clientState.value.clientID,
            onValueChange = { clientState.value.clientID = it }
        )

        TextInput(
            title = "Username",
            value = clientState.value.username,
            onValueChange = { clientState.value.username = it }
        )

        TextInput(
            title = "Password",
            value = clientState.value.password,
            onValueChange = { clientState.value.password = it }
        )

        Button(onClick = { /*TODO*/ }) {
            Text(text = "CLEAN")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "CONNECT")
        }
    }
}

@Composable
fun TextInput(
    title: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        Modifier.padding(
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        Text(text = title)
        TextField(
            value = value,
            placeholder = {
                Text(text = title)
            },
            onValueChange = onValueChange
        )
    }
}

@Preview
@Composable
fun ConnectPreview() {
    Connect()
}