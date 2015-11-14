package com.nadya.vibration;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by Nadya on 14/11/2015.
 */
public class Vibrator {extends AppWidgetProvider
    private final Context context;

    private final AppWidgetManager appWidgetManager;

    {
        @Override
        public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

                final int N = appWidgetIds.length;
         for (int i = 0; i < N; i++) {
             updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
         }}
                  @Override
        public void onEnabled(Context context){
        }
    @Override
        public void onDisabled(Context context) {
                     }
        public void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
            final Vibrator vibe = (Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

           CharSequence widgetText = context.getString(R.string.appwidget_text);
            Intent intent = new Intent(context, Vibrator.class);
            intent.setAction(appWidgetManager.ACTION_APPWIDGET_UPDATE);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.tvibrator);
            views.setOnClickPendingIntent(R.id.button, pendingIntent);
            vibe.vibrate(100);
                   appWidgetManager.updateAppWidget(appWidgetId, views);
            }


}
