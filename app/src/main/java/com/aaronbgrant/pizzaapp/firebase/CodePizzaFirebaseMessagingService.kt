package com.aaronbgrant.pizzaapp.firebase

import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.aaronbgrant.pizzaapp.dataStore
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CodePizzaFirebaseMessagingService: FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.v("CloudMessage", "From ${message.from}")
        if(message.data.isNotEmpty()){
            Log.v("CloudMessage", "Message Data : ${message.data}")
        }
        message.data?.let{
            Log.v("CloudMessage", "Message Notification Payload: ${it["body"]}")
        }

        message.notification?.let{
            Log.v("CloudMessage", "Notification: ${it}")
            Log.v("CloudMessage", "Notification Title: ${it.title}")
            Log.v("CloudMessage", "Notification Body: ${it.body}")
        }

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        GlobalScope.launch {
            saveGCMToken(token)
        }
    }

    private suspend fun saveGCMToken(token: String) {
        val gcmTokenKey = stringPreferencesKey("GCM_TOKEN")
        baseContext.dataStore.edit { pref ->
            pref[gcmTokenKey] = token
        }
    }
}