package com.project.mayday.push

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.project.mayday.R
import com.project.mayday.provider.ResourceProvider
import org.koin.android.ext.android.inject
import java.net.URL

class FirebasePushService : FirebaseMessagingService() {

    private val context: Application by inject()
    private val resourceProvider: ResourceProvider by inject()

    /**
     * 구글 토큰 값 흭득
     * 아래 토큰은 앱이 설치된 디바이스에 대한 고유값으로 푸시를 보낼때 사용
     */
    override fun onNewToken(token: String) {
        Log.d(TAG, "onNewToken: $token")
    }

    /**
     * 메시지를 받았을 경우 그 메시지에 대하여 구현
     */
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "onMessageReceived")

        remoteMessage.data.let {
            Log.d(TAG, "Message data Payload:$it")
        }
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body + ${it.body}..Message title: + ${it.title}")
        }

        sendNotification(remoteMessage.data)
    }

    private fun sendNotification(remoteNoti: Map<String, String>?) {

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notiManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        remoteNoti?.let { noti ->
            val notiBuilder = NotificationCompat.Builder(this, "0")
//                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.place_holder))
//                .setSmallIcon(R.drawable.place_holder)
                .setContentTitle(noti["Title"])
                .setContentText(noti["Body"])
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                //드래그 했을 때
                .setStyle(noti["ImgUrl"]?.let {
                    val url = URL(it)
                    val bigPicture =
                        BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(bigPicture)
                        .setBigContentTitle(noti["Title"])
                        .setSummaryText(noti["Body"])
                })

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notiChannel =
                    NotificationChannel("0", "MayDay", NotificationManager.IMPORTANCE_HIGH)
                notiManager.createNotificationChannel(notiChannel)
            }
            notiManager.notify(0, notiBuilder.build())
        }
    }

    companion object {
        const val TAG = "FirebasePushService"
    }
}