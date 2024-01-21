package com.narcis.broadcast.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.lang.StringBuilder

private const val TAG = "GoogleSampleReceiver"
class GoogleSampleReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action ${intent.action}\n")
            append("URI ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                Log.d(TAG, log)
                // show on view
            }
        }
    }
}
