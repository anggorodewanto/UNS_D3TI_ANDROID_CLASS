package com.nisrina.praktvibrate;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Random;

public class NewAppWidget extends AppWidgetProvider {
    private static final String ACTION_CLICK = "ACTION_CLICK";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // Get all ids
        ComponentName thisWidget = new ComponentName(context,
                NewAppWidget.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100));
            Log.w("WidgetExample", String.valueOf(number));
            // Set the text

            // Register an onClickListener
            Intent intent = new Intent(context, NewAppWidget.class);
//            Intent intent = new Intent();

//            intent.setAction("com.example.setiadidarmawan.widgetmbuh");
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            intent.setAction("ACTION");
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

//            if(intent.getAction().equals("ACTION")) {
//                Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
//                vibrator.vibrate(10000);
//
//                CharSequence text = "Hp Bergetar";
//                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
//                toast.show();
//            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.new_app_widget);
            remoteViews.setTextViewText(R.id.appwidget_text, String.valueOf(number));

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

        if(intent.getAction().equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)){
            Vibrator vibrator=(Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(10000);

            CharSequence text = "Hp Bergetar";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
//                         vibrate(context);
        }
        appWidgetManager.updateAppWidget(new ComponentName(context, NewAppWidget.class), views);
    }


    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int mAppWidgetId) {
        Vibrator vibrator=(Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(10000);

        CharSequence text = "Hp Bergetar";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

}
