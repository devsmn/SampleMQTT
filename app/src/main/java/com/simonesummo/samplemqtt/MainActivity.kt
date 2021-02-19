package com.simonesummo.samplemqtt

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simonesummo.samplemqtt.ui.Connect
import com.simonesummo.samplemqtt.ui.theme.SampleMQTTTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            SampleMQTTTheme {
                NavHost(navController, startDestination = NavDestination.Connect) {
                    composable(NavDestination.Connect) {
                        Connect()
                    }
                    composable(NavDestination.Chat) {
                        // Call the
                    }
                }
            }
        }

        /* Check if Internet connection is available */
        if (!isConnected()) {
            Log.d(this.javaClass.name, "Internet connection NOT available")

            Toast.makeText(
                applicationContext,
                "Internet connection NOT available",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun isConnected(): Boolean {
        var result = false
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        if (activeNetwork != null) {
            // connected to the internet
            result = when (activeNetwork.type) {
                ConnectivityManager.TYPE_WIFI,
                ConnectivityManager.TYPE_MOBILE,
                ConnectivityManager.TYPE_VPN -> true
                else -> false
            }
        }

        return result
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleMQTTTheme {
        Greeting("Android")
    }
}