package com.example.windows7.praktikum_3;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView title = new TextView(this);
        final EditText input = new EditText(this);
        Button buton = new Button(this);

        title.setText("Search Location");
        title.setTextSize(14);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setGravity(Gravity.CENTER);
        buton.setGravity(Gravity.CENTER);
        buton.setText("Launch Maps");

        LinearLayout tampil = new LinearLayout(this);

        tampil.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        input.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buton.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        tampil.setOrientation(LinearLayout.VERTICAL);
        tampil.setGravity(Gravity.CENTER);

        tampil.addView(title);
        tampil.addView(input);
        tampil.addView(buton);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search=input.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+search));
                startActivity(intent);
            }
        });
        setContentView(tampil);
    }}

