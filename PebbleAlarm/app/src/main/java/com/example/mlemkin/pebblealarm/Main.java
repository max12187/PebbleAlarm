package com.example.mlemkin.pebblealarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TimePicker;
import android.widget.Switch;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.Calendar;
import java.util.UUID;


public class Main extends Activity {
    PendingIntent intentIds[] = new PendingIntent[7];
    PendingIntent intentIdsWatch[] = new PendingIntent[7];

    BroadcastReceiver receivers[] = new BroadcastReceiver[7];
    BroadcastReceiver receiversWatch[] = new BroadcastReceiver[7];

    Main main = this;

    Uri notification;
    Ringtone ringtone;

    AlarmManager alarmManager;

    int hour;
    int minute;


    int PRE_ALARM = 60000;

    private final static UUID PEBBLE_APP_UUID = UUID.fromString("4c17b351-84f4-412c-b5e7-1ea3c86c9ead");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        PebbleDictionary data = new PebbleDictionary();
        data.addString(0, "balls");
        PebbleKit.sendDataToPebble(getApplicationContext(), PEBBLE_APP_UUID, data);


        boolean connected = PebbleKit.isWatchConnected(getApplicationContext());

        notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = (AlarmManager)(getSystemService(Context.ALARM_SERVICE));

        CheckBox sunday = (CheckBox)findViewById(R.id.Sunday);
        CheckBox monday = (CheckBox)findViewById(R.id.Monday);
        CheckBox tuesday = (CheckBox)findViewById(R.id.Tuesday);
        CheckBox wednesday = (CheckBox)findViewById(R.id.Wednesday);
        CheckBox thursday = (CheckBox)findViewById(R.id.Thursday);
        CheckBox friday = (CheckBox)findViewById(R.id.Friday);
        CheckBox saturday = (CheckBox)findViewById(R.id.Saturday);

        TimePicker time = (TimePicker)findViewById(R.id.timePicker);

        hour = time.getCurrentHour();
        minute = time.getCurrentMinute();

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                main.hour = hourOfDay;
                main.minute = minute;

              System.out.println("test: "+hourOfDay +" : " + minute);



            }
        });


        sunday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch
                            System.out.println("second");

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "sunday", 0, Calendar.SUNDAY, hour, minute, PRE_ALARM);
                    System.out.println("test2 :" + hour);
                    System.out.println("test2 :" + minute);



                }
                else{
                    deregister(0);

                }

            }
        });
        monday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "monday", 1, Calendar.MONDAY, hour, minute, PRE_ALARM);



                }
                else{
                    deregister(1);

                }

            }
        });
        tuesday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "tuesday", 2, Calendar.TUESDAY, hour, minute, PRE_ALARM);



                }
                else{
                    deregister(2);

                }

            }
        });
        wednesday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "wednesday", 3, Calendar.WEDNESDAY, hour, minute, PRE_ALARM);



                }
                else{
                    deregister(3);

                }

            }
        });
        thursday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "thursday", 4, Calendar.THURSDAY, hour, minute, PRE_ALARM);



                }
                else{
                    deregister(4);

                }

            }
        });
        friday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "friday", 5, Calendar.FRIDAY, hour, minute, PRE_ALARM);



                }
                else{
                    deregister(5);

                }

            }
        });
        saturday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context c, Intent i) {
                            play();
                        }
                    };

                    BroadcastReceiver broadcastReceiverWatch = new  BroadcastReceiver() {
                        @Override
                        public void onReceive(Context c, Intent i) {
                            //code to be sent to watch

                        }
                    };

                    register(broadcastReceiver, broadcastReceiverWatch, "saturday", 6, Calendar.SATURDAY, hour, minute, PRE_ALARM);



                }
                else{
                    deregister(6);

                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

     public void play(){

         ringtone.play();
         System.out.println("balls");

    }

    public void setAlarm(int dayOfWeek, int hour, int minute, long preAlarm, PendingIntent pendingIntent,PendingIntent pendingIntentWatch  ){
        Calendar calender = Calendar.getInstance();

        calender.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        calender.set(Calendar.HOUR_OF_DAY, hour);
        calender.set(Calendar.MINUTE, minute);


        System.out.println(calender.get(Calendar.DAY_OF_WEEK) +" : "+ calender.get(Calendar.HOUR_OF_DAY)+ " : " + calender.get(Calendar.MINUTE));



        alarmManager.set(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(), pendingIntent);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis() - preAlarm, pendingIntentWatch);


    }

    public void register(BroadcastReceiver receiver, BroadcastReceiver receiverWatch, String day, int index, int dayOfWeek, int hour, int minute, long preAlarm){
        registerReceiver(receiver, new IntentFilter("com.PebbleAlarm.Alarm."+day));
        registerReceiver(receiverWatch, new IntentFilter("com.PebbleAlarm.WatchAlarm."+day));

        PendingIntent pendingIntent = PendingIntent.getBroadcast(main, 0, new Intent("com.PebbleAlarm.Alarm."+day),0 );
        PendingIntent pendingIntentWatch = PendingIntent.getBroadcast(main, 0, new Intent("com.PebbleAlarm.WatchAlarm."+day),0 );

        intentIds[index] = pendingIntent;
        intentIdsWatch[index] = pendingIntentWatch;

        receivers[index] = receiver;
        receiversWatch[index] = receiverWatch;

        setAlarm(dayOfWeek, hour, minute, preAlarm, pendingIntent, pendingIntentWatch);

    }

    public void deregister(int index){
        alarmManager.cancel(intentIds[index]);
        alarmManager.cancel(intentIdsWatch[index]);

        unregisterReceiver(receivers[index]);
        unregisterReceiver(receiversWatch[index]);


    }

}
