package com.example.mega.tgs_klm6;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ClockService extends Service {
    public static final String UPDATE = "update";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Context context = getApplicationContext();
        int appWidgetId = intent.getExtras().getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID);
        RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.main_widget);
        AppWidgetManager appWidgetManager = AppWidgetManager
                .getInstance(context);
        Format formatter = new SimpleDateFormat(
                "EEEE, MMMM d yyyy\nhh:mm:ss a z", Locale.getDefault());
        String currentTime = formatter.format(new Date());
        views.setTextViewText(R.id.time_label, currentTime);

        appWidgetManager.updateAppWidget(appWidgetId, views);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
