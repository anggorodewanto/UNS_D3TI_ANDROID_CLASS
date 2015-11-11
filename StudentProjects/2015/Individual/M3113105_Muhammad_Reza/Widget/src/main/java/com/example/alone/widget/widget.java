package com.example.alone.widget;

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

/**
 * Created by alone on 11/11/2015.
 */
public class widget extends AppWidgetProvider {

    private static final String action_clik = "Action_Clik";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appwidgetid){
        ComponentName thiswidget = new ComponentName(context, widget.class);

        int[] allwidgetid = appWidgetManager.getAppWidgetIds(thiswidget);
        for (int widgetid : allwidgetid){
            int number = (new Random().nextInt(100));
            Log.w("WidgetExample", String.valueOf(number));

            Intent intent = new Intent(context,widget.class);

            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appwidgetid);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget);
            remoteViews.setTextViewText(R.id.button, String.valueOf(number));

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.button, pendingIntent);
            appWidgetManager.updateAppWidget(widgetid,remoteViews);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent){
        super.onReceive(context, intent);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

        if(intent.getAction().equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)){
            Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService(context.VIBRATOR_SERVICE);
            vibrator.vibrate(10000);

            CharSequence text = "Mulai Getar";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);

            toast.show();
        }
        appWidgetManager.updateAppWidget(new ComponentName(context,widget.class), remoteViews);
    }

    @Override
    public void onEnabled(Context context){

    }

    @Override
    public  void onDisabled(Context context){

    }

    static void updateAppWidget(Context context,AppWidgetManager appWidgetManager,int button){
        Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(10000);

        CharSequence text = "Mulai Getar";
        Toast toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
        toast.show();
    }
}
