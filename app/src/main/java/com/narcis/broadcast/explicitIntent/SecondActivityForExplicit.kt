package com.narcis.broadcast.explicitIntent

import android.app.Activity
import android.app.Activity.RESULT_OK
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
import androidx.compose.ui.tooling.preview.Preview
import com.narcis.broadcast.explicitIntent.ui.theme.AndroidBroadcastReciverTheme

class SecondActivityForExplicit : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // extracting intent data :
        val extras = intent.extras ?: return
        val qString = extras.getString("qString")

        setContent {
            AndroidBroadcastReciverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    setResult(RESULT_OK)
                    SecondViewForExplicit(qString?: "", context = this)
                }
            }
        }
    }

    override fun finish() {

        super.finish()
    }
}

@Composable
fun SecondViewForExplicit(qString: String, context: Activity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val editText = remember { mutableStateOf("") }
        Text(text = qString)
        TextField(
            value = editText.value,
            onValueChange =
            { editText.value = it },
        )
        Button(onClick = { sendBackData(context, editText.value) }) {
            Text(text = "Return Text")
        }
    }
}
fun sendBackData(context: Activity, sendData: String) {
   val data = Intent()
   data.putExtra("returnData", sendData)
   context.setResult(RESULT_OK, data)
    context.finish()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    AndroidBroadcastReciverTheme {
        SecondViewForExplicit("Android", SecondActivityForExplicit())
    }
}
