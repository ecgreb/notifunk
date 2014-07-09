package com.ecgreb.notifunk;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifunktivity extends Activity {
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, Notifunktivity.class);
        pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        final Notification.Action call =
                new Notification.Action(android.R.drawable.ic_menu_call, "Call", pendingIntent);

        final Notification.Action cancel =
                new Notification.Action(android.R.drawable.ic_menu_close_clear_cancel, "Cancel",
                        pendingIntent);

        Button notifyButton = (Button) findViewById(R.id.notify);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.Builder builder = new Notification.Builder(Notifunktivity.this)
                        .setContentTitle("Montell Jordan")
                        .setContentText("I'm kinda buzzed and it's all because")
                        .setTicker("I'm kinda buzzed and it's all because")
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setContentIntent(pendingIntent)
                        .setVisibility(Notification.VISIBILITY_PRIVATE)
                        .addAction(call)
                        .addAction(cancel)
                        .setAutoCancel(true);

                Notification notification = builder.build();
                notification.defaults |= Notification.DEFAULT_SOUND;
                notification.defaults |= Notification.DEFAULT_VIBRATE;
                notificationManager.notify(0, notification);
            }
        });

        Button headsUpButton = (Button) findViewById(R.id.heads_up);
        headsUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.Builder builder = new Notification.Builder(Notifunktivity.this)
                        .setContentTitle("Montell Jordan")
                        .setContentText("South Central does it like nobody does")
                        .setTicker("South Central does it like nobody does")
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setContentIntent(pendingIntent)
                        .setVisibility(Notification.VISIBILITY_PUBLIC)
                        .addAction(call)
                        .addAction(cancel)
                        .setAutoCancel(true);

                Notification notification = builder.build();
                notification.defaults |= Notification.DEFAULT_SOUND;
                notification.defaults |= Notification.DEFAULT_VIBRATE;
                notificationManager.notify(1, notification);
            }
        });

        Button secretButton = (Button) findViewById(R.id.secret);
        secretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.Builder builder = new Notification.Builder(Notifunktivity.this)
                        .setContentTitle("Montell Jordan")
                        .setContentText("To all my neighbors you got much flavor")
                        .setTicker("To all my neighbors you got much flavor")
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setContentIntent(pendingIntent)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setVisibility(Notification.VISIBILITY_SECRET)
                        .addAction(call)
                        .addAction(cancel)
                        .setAutoCancel(true);

                Notification notification = builder.build();
                notification.defaults |= Notification.DEFAULT_SOUND;
                notification.defaults |= Notification.DEFAULT_VIBRATE;
                notificationManager.notify(2, notification);
            }
        });
    }
}
