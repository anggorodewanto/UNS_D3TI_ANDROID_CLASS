package com.example.juanaldo.tugastheme;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;


    @SuppressWarnings("deprecation")
    public class MainActivity extends TabActivity {

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TabHost tabhost = getTabHost();
            TabHost.TabSpec spec;
            Intent intent;

            intent = new Intent().setClass(this, CallActivity.class);//content pada tab yang akan kita buat
            spec = tabhost.newTabSpec("call").setIndicator("Call",null).setContent(intent);//mengeset nama tab dan mengisi content pada menu tab anda.
            tabhost.addTab(spec);//untuk membuat tabbaru disini bisa diatur sesuai keinginan anda

            intent = new Intent().setClass(this, ChatActivity.class);
            spec = tabhost.newTabSpec("chat").setIndicator("Chat",null).setContent(intent);
            tabhost.addTab(spec);

            intent = new Intent().setClass(this, ContactActivity.class);
            spec = tabhost.newTabSpec("teman").setIndicator("Teman",null).setContent(intent);
            tabhost.addTab(spec);

        }
    }
