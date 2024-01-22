package com.narcis.broadcast.explicitIntent

import android.app.Activity
import android.content.Context
import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
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
                    ExplicitIntentView(this)
                }
            }
        }
    }
}

@Composable
fun ExplicitIntentView(applicationContext: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val editText = remember { mutableStateOf("") }
        TextField(
            value = editText.value,
            onValueChange = { editText.value = it },
        )
        Text(text = "Hello World!")
        Button(onClick = {
            sendIntent(
                applicationContext,
                SecondActivityForExplicit(),
                editText.value,
            )
        }) {
            Text(text = "Send Text")
        }
    }
}

private fun sendIntent(context: Context, activity: Activity, data: String) {
    val i = Intent(context, activity::class.java)
    i.putExtra("qString", data)
    context.startActivity(i)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AndroidBroadcastReciverTheme {
        ExplicitIntentView(LocalContext.current)
    }
}
