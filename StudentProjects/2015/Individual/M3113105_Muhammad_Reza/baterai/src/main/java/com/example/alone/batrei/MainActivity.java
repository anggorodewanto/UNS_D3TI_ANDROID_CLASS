package com.example.alone.batrei;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    Button btnReadBattery;
    ImageView imageIcon;
    TextView textBatteryStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReadBattery = (Button)findViewById(R.id.readbattery);
        imageIcon = (ImageView)findViewById(R.id.icon);
        textBatteryStatus = (TextView)findViewById(R.id.batterystatus);

        btnReadBattery.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                textBatteryStatus.setText(readBattery());
            }
        });

    }

    private String readBattery(){
        StringBuilder sb = new StringBuilder();
        IntentFilter batteryIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryIntent = registerReceiver(null, batteryIntentFilter);

        boolean  present= batteryIntent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
        sb.append("PRESENT: " + present + "\n");

        int status = batteryIntent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        if(status == BatteryManager.BATTERY_STATUS_CHARGING){
            sb.append("BATTERY_STATUS_CHARGING\n");
        }
        if(status == BatteryManager.BATTERY_STATUS_FULL){
            sb.append("BATTERY_STATUS_FULL\n");
        }

        int plugged = batteryIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        if(plugged == BatteryManager.BATTERY_PLUGGED_USB){
            sb.append("BATTERY_PLUGGED_USB\n");
        }
        if(plugged == BatteryManager.BATTERY_PLUGGED_AC){
            sb.append("BATTERY_PLUGGED_AC\n");
        }

        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        sb.append("LEVEL: " + level + "\n");

        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        sb.append("SCALE: " + scale + "\n");

        int  health = batteryIntent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
        sb.append("health: " + convHealth(health) + "\n");

        String  technology = batteryIntent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
        sb.append("TECHNOLOGY: " + technology + "\n");

        int  temperature = batteryIntent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
        sb.append("TEMPERATURE: " + temperature + "\n");

        int  voltage = batteryIntent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);
        sb.append("VOLTAGE: " + voltage + "\n");

        //I have no idea how to load the small icon from system resources!
        int  icon_small_resourceId = batteryIntent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,0);
        sb.append("ICON_SMALL: " + icon_small_resourceId + "\n");

        return sb.toString();
    }

    private String convHealth(int health){
        String result;
        switch(health){
            case BatteryManager.BATTERY_HEALTH_COLD:
                result = "BATTERY_HEALTH_COLD";
                break;
            case BatteryManager.BATTERY_HEALTH_DEAD:
                result = "BATTERY_HEALTH_DEAD";
                break;
            case BatteryManager.BATTERY_HEALTH_GOOD:
                result = "BATTERY_HEALTH_GOOD";
                break;
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                result = "BATTERY_HEALTH_OVERHEAT";
                break;
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                result = "BATTERY_HEALTH_OVER_VOLTAGE";
                break;
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                result = "BATTERY_HEALTH_UNKNOWN";
                break;
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                result = "BATTERY_HEALTH_UNSPECIFIED_FAILURE";
                break;
            default:
                result = "unkknown";
        }

        return result;
    }
}
