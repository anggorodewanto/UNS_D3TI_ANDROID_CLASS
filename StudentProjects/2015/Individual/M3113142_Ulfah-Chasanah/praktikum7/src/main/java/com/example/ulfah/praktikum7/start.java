package com.example.ulfah.praktikum7;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ulfah on 1/4/2016.
 */
public class Start extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "AcademyKiller.ttf");
        TextView myTextView = (TextView)
                findViewById(R.id.textView2);
        myTextView.setTypeface(myTypeface);

    }

}

