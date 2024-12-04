package com.student.unicdastudentsapp.domain.api

import android.provider.Settings
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.student.unicdastudentsapp.domain.repository.FirebaseMessagingRepositoryImpl
import java.util.Calendar


class PushNotificactions : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("NEW_TOKEN", "Refreshed token: $token")
        val calendar = Calendar.getInstance()
        val id: String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val tokenMapper = hashMapOf<String, String>(
            "date" to calendar.time.toString(),
            "deviceID" to id,
            "token" to token
        )
        FirebaseMessagingRepositoryImpl().saveToken(tokenMapper);
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

    @Deprecated("Deprecated in Kotlin")
    override fun onSendError(messageId: String, exception: Exception) {
        super.onSendError(messageId, exception)
        Log.d("PUSH error", "Invalid server key: $exception")
    }
}