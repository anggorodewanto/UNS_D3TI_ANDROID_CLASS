package com.example.asus.vibrate;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by asus on 15/11/2015.
 */
public class Vibrator extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgateIds){
        final int r = appWidgateIds.length;
        for (int i = 0; i <r; i++){
            updateAppWidget(context, appWidgetManager, appWidgateIds[i]);
        }
    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {

    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,int appWidgetId) {
        final android.os.Vibrator vb = (android.os.Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        CharSequence widgetText = context.getString(R.string.appwidget_text);
        Intent intent = new Intent(context, android.os.Vibrator.class);
        intent.setAction(appWidgetManager.ACTION_APPWIDGET_UPDATE);
        PendingIntent pendingIntent= PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT );

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);

        views.setOnClickPendingIntent(R.id.button, pendingIntent);
        vb.vibrate(100);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
