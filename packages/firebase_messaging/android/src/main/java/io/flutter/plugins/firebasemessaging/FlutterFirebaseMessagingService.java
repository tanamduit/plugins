// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.firebasemessaging;

import android.content.Intent;
import android.content.Context;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.os.Build;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FlutterFirebaseMessagingService extends FirebaseMessagingService {

  public static final String ACTION_REMOTE_MESSAGE =
      "io.flutter.plugins.firebasemessaging.NOTIFICATION";
  public static final String EXTRA_REMOTE_MESSAGE = "notification";

  /**
   * Called when message is received.
   *
   * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
   */
  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    Intent intent = new Intent(ACTION_REMOTE_MESSAGE);
    intent.putExtra(EXTRA_REMOTE_MESSAGE, remoteMessage);
    // PendingIntent pi = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
    // String channelid = "channeltanamduit";
    // NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channelid)
    //     .setSmallIcon(FirebaseMessagingPlugin.registrar.context().getResources().getIdentifier("ic_launcher_release","mipmap",FirebaseMessagingPlugin.registrar.context().getPackageName()))
    //     .setContentTitle(remoteMessage.getNotification().getTitle())
    //     .setContentText(remoteMessage.getNotification().getBody())
    //     .setAutoCancel(true)
    //     .setContentIntent(pi);
    // NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    // if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
    //   NotificationChannel chn = new NotificationChannel(channelid,"default",NotificationManager.IMPORTANCE_DEFAULT);
    //   nm.createNotificationChannel(chn);
    // }
    // nm.notify(0,builder.build());
    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
  }
}
