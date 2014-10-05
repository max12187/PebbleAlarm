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
import java.util.Calendar;

/**
 * Created by mlemkin on 10/4/2014.
 */
public class Alarm {


    BroadcastReceiver broadcastReceiver;
    BroadcastReceiver broadcastReceiverWatch;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    PendingIntent pendingIntentWatch;
    Ringtone ringtone;


    public Alarm(Main main, Ringtone ringtone){
        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context c, Intent i) {

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

    public PendingIntent[] setAlarm(int dayOfWeek, int hour, int minute, int second, long preAlarm ){
        Calendar calender = Calendar.getInstance();

        calender.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        calender.set(Calendar.HOUR_OF_DAY, hour);
        calender.set(Calendar.MINUTE, minute);
        calender.set(Calendar.SECOND, second);



        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, calender.getTimeInMillis(), pendingIntent);

        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, calender.getTimeInMillis() - preAlarm, pendingIntentWatch);

        return new PendingIntent[]{pendingIntent, pendingIntentWatch};
    }

    public void play(){
        ringtone.play();

    }




}
