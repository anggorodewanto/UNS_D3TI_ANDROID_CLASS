package com.alpha.views;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.intent


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
	
	public static final String EXTRA_PESAN = "info.bekti.develop.PESAN"; 
	
	public void kirimPesan(View view){
		//perintah jika tombol di klik
		Intent intent = new Intent(this, MainActivity.class);
		EditText editText= (EditText) findViewById(R.id.edit_pesan);
		String pesan= editText.getText().toString();
		intent.putExtra(EXTRA_PESAN, pesan);
		startActivity(intent);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
