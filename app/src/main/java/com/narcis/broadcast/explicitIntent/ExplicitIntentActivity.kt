package com.narcis.broadcast.explicitIntent

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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.narcis.broadcast.explicitIntent.ui.theme.AndroidBroadcastReciverTheme

class ExplicitIntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBroadcastReciverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ExplicitIntentView("Android")
                }
            }
        }
    }
}

@Composable
fun ExplicitIntentView(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val editText = remember { mutableStateOf("") }
        TextField(value = editText.value, onValueChange = {})
        Text(text = "Hello World!")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Send Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AndroidBroadcastReciverTheme {
        ExplicitIntentView("Android")
    }
}
