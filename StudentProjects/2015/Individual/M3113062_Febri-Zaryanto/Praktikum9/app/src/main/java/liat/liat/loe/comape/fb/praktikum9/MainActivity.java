package liat.liat.loe.comape.fb.praktikum9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    MusicService ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }


        });

        final Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();

            }
        });
}
    private void pause(){
        ms.stop();
    }
    private void stop(){
        Intent intent = new Intent(this, MusicService.class);
        stopService(intent);
    }
    private void play(){
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
    }