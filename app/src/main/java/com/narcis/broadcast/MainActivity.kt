package com.narcis.broadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.narcis.broadcast.receiver.ActionReceiver
import com.narcis.broadcast.receiver.MyReceiver
import com.narcis.broadcast.ui.theme.AndroidBroadcastReciverTheme

class MainActivity : ComponentActivity() {
    private var receiver: BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * sending a sample broadcast wit intent
         */
        val intent = Intent()
        intent.action = "com.narcis.broadcast"
        intent.putExtra("ImLive", 100)
        intent.flags =
            Intent.FLAG_INCLUDE_STOPPED_PACKAGES // intent is allowed to start a component when the application
        // is stopped
        sendBroadcast(intent)

        /**
         * how to register broadcast receiver for android 8 and later :
         */
        val filter = IntentFilter()
        filter.addAction("com.narcis.broadcast")
        val receiver = MyReceiver()
        registerReceiver(receiver, filter)

        // unregistering :
        unregisterReceiver(receiver)
        setContent {
            AndroidBroadcastReciverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting({ broadcastIntent() })
                }
            }
        }
        configureReceiver()
    }

    private fun broadcastIntent() {
        val intent = Intent()
        intent.action = "com.narcis.broadcast"
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("com.narcis.broadcast")
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        receiver = ActionReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}

@Composable
fun Greeting(action: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = action) {
            Text(
                text = "Send Broadcast",
                color = Color.Black,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBroadcastReciverTheme {
        Greeting({})
    }
}
