package com.narcis.broadcast.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ActionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
       Toast.makeText(context, "Broadcast Intent Detected", Toast.LENGTH_LONG).show()
    }
}