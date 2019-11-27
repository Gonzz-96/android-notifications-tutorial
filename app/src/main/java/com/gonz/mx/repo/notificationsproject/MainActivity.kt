package com.gonz.mx.repo.notificationsproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

private const val CHANNEL_ID = "gonz-notification-channel"
private const val CHANNEL_NAME = "Gonz Notification"
private const val CHANNEL_DESCRIPTION = "This is a tutorial"

class MainActivity : AppCompatActivity() {

    // To create a notification we need...
    // 1. Notification channel
    // 2. Notification builder
    // 3. Notification manager

    override fun onCreate(savedInstanceState: Bundle?) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.description = CHANNEL_DESCRIPTION

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(notificationChannel)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNotification()
    }

    private fun showNotification() {

        val myNotificationBuilder =
            NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("It's working!")
                .setContentText("My first notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = NotificationManagerCompat.from(this)

        manager.notify(1, myNotificationBuilder.build())
    }

}
