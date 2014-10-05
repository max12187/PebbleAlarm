package com.example.mlemkin.pebblealarm;
import android.content.BroadcastReceiver;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.media.RingtoneManager;
import android.media.Ringtone;
import android.app.PendingIntent;
import android.content.IntentFilter;

/**
 * Created by mlemkin on 10/4/2014.
 */
public class Alarm {


    BroadcastReceiver broadcastReceiver;
    BroadcastReceiver broadcastReceiverWatch;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    PendingIntent pendingIntentWatch;


    public Alarm(final Main main){

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(main.getApplicationContext(), notification);
                ringtone.play();
            }
        };

        broadcastReceiverWatch = new  BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
               //code to be sent to watch

            }
        };

        main.registerReceiver(broadcastReceiver, new IntentFilter("com.PebbleAlarm.Alarm") );
        main.registerReceiver(broadcastReceiverWatch, new IntentFilter("com.PebbleAlarm.WatchAlarm") );

        pendingIntent = PendingIntent.getBroadcast(main, 0, new Intent("com.PebbleAlarm.Alarm"),0 );
        pendingIntentWatch = PendingIntent.getBroadcast(main, 0, new Intent("com.PebbleAlarm.WatchAlarm"),0 );

        alarmManager = (AlarmManager)(main.getSystemService( Context.ALARM_SERVICE ));

    }

    public void setAlarm(long alarmTime, long preAlarm ){
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime, pendingIntent);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime - preAlarm, pendingIntentWatch);
    }




}
