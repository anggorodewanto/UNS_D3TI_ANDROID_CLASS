package com.example.muawana.tugas8_getar;

/**
 * Created by root on 11/15/15.
 */

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.RemoteViews;

public class widget extends AppWidgetProvider{
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int A = appWidgetIds.length;
        for (int i = 0; i < A; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,int appWidgetId) {

        final Vibrator getar = (Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

        CharSequence widgetText = context.getString(R.string.app_name);
        // Construct the RemoteViews object
        Intent intent = new Intent(context, getar.class);
        intent.setAction(appWidgetManager.ACTION_APPWIDGET_UPDATE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.getar);

        views.setOnClickPendingIntent(R.id.button, pendingIntent);
        getar.vibrate(100);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}


