package com.example.user.kelompok3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Created by USER on 07/10/2015.
 */
public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener{
    private static int seekvalue=10;
    private static EditText editText;

    ToolbarListener activityCallback;

    public interface ToolbarListener{
        void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCallback = (ToolbarListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString()+"must implement ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.toolbar_fragment,container, false);
        editText = (EditText) view.findViewById(R.id.editText);
        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        final Button button = (Button) view.findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonClicked(view);
            }
        });
        return view;
    }

    public void buttonClicked(View view){
        activityCallback.onButtonClick(seekvalue,editText.getText().toString());
    }

    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
        seekvalue=progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {

    }
}
