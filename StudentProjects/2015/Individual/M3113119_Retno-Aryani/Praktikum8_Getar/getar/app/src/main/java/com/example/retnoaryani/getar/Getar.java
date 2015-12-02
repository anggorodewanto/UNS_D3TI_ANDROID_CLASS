package com.example.retnoaryani.getar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.RemoteViews;

/**
 * Created by RetnoAryani on 12/2/2015.
 */
public class Getar extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        final Vibrator vibe = (Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

        CharSequence widgetText = context.getString(R.string.hello_world);
        // Construct the RemoteViews object
        Intent intent = new Intent(context, Getar.class);
        intent.setAction(appWidgetManager.ACTION_APPWIDGET_UPDATE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);

        views.setOnClickPendingIntent(R.id.tombol, pendingIntent);
        vibe.vibrate(100);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

}
