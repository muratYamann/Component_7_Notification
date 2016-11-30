package com.yamankod.component_7_notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button start, stop;
    private int notID = 1;
    private int currentapiVersion = android.os.Build.VERSION.SDK_INT;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        start.setOnClickListener(startlisten);
        stop.setOnClickListener(stoplisten);
    }
    OnClickListener startlisten = new OnClickListener() {
        public void onClick(View v) {

                create_nt2();

        }
    };
    OnClickListener stoplisten = new OnClickListener() {
        public void onClick(View v) {
            close_nt();
        }
    };

    //Buton 2 de setLatestEventInfo metodu apı 23 ile ortadan kaldırılmış.
    private void create_nt(){
        NotificationManager ntmn = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int icon = R.drawable.ic_launcher;
        CharSequence tickertext = "android notification!";
        long when = System.currentTimeMillis();
        Notification nt = new Notification(icon,tickertext,when);
        Context cn = getApplicationContext();
        CharSequence cntitle = "Android!!";
        CharSequence cntext = "I want to learn Android";
        Intent nt_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kocaeli.edu.tr"));
        PendingIntent pd_intent = PendingIntent.getActivity(this, 0, nt_intent, 0);
        //nt.setLatestEventInfo(cn, cntitle, cntext, pd_intent); Bu Metod Apı 23 ile kaldırılmıs
        ntmn.notify(notID, nt);
        Toast.makeText(cn, "Buton 2 de setLatestEventInfo metodu apı 23 ile ortadan kaldırılmış.", Toast.LENGTH_SHORT).show();

    }
    private void create_nt2(){
        NotificationManager ntmn = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kegm.gov.tr"));
        PendingIntent pd_Intent =PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Notification Başlığı")
                .setContentText("Burası Notification gövde")
                .setTicker("Notificaiton çıktı! ")
                .setWhen(new Date().getTime())
                .setContentIntent(pd_Intent);
        ntmn.notify(notID, mBuilder.build());
    }
    private void close_nt(){
        NotificationManager ntmn =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        ntmn.cancel(notID);
    }
}
