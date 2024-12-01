package com.student.unicdastudentsapp.data.remote.api

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotificactions : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token);
        Log.d("NEW_TOKEN", "Refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("PUSH RECEIVED", "Message data: ${remoteMessage.data}")
        // Display push notification
    }
    override fun onDeletedMessages() {
        super.onDeletedMessages()
        Log.d("PUSH not registred handler", "Device not registered")
    }
    override fun onSendError(messageId: String, exception: Exception) {
        super.onSendError(messageId, exception)
        Log.d("PUSH error", "Invalid server key: $exception")
    }
}