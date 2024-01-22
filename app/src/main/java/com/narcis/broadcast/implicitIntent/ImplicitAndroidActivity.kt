package com.narcis.broadcast.implicitIntent

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.narcis.broadcast.implicitIntent.ui.theme.AndroidBroadcastReciverTheme
import java.net.URL

class ImplicitAndroidActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBroadcastReciverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ImplicitIntentView("Android")
                }
            }
        }
    }
}

@Composable
fun ImplicitIntentView(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Show Web Page")
        }
        Spacer(modifier = Modifier.height(80.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Enable Links")
        }
    }
}
fun showWebPage(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebookfrenzy.com"))
    context.startActivity(intent)
}
private fun handleIntent(intent: Intent) {
    val data = intent.data
    var url: URL? = null

    try {
        url = URL(
            data?.scheme,
            data?.host,
            data?.path,
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
fun enableLink() {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    AndroidBroadcastReciverTheme {
        ImplicitIntentView("Android")
    }
}
