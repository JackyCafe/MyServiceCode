package com.ian.myservicecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView numText;
    private int hours = 12;
    private int min = 0;
    private NumberPicker hourPicker,minPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numText = (TextView) findViewById(R.id.textView);
        hourPicker = (NumberPicker)findViewById(R.id.numberPicker_H);
        minPicker = (NumberPicker) findViewById(R.id.numberPicker_M);
        hourPicker.setMaxValue(23);
        hourPicker.setMinValue(0);
        minPicker.setMaxValue(59);
        minPicker.setMinValue(0);
        Date date = new Date();

        hourPicker.setValue(Integer.parseInt(new SimpleDateFormat("HH").format(date)));
        minPicker.setValue(Integer.parseInt(new SimpleDateFormat("mm").format(date)));

        hourPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                hourPicker.setValue(newVal);
            }
        });
        minPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPicker.setValue(newVal);
            }
        });

//



    }

    public void send(View view) {
        Intent it = new Intent(this,Swe.class);
        hours = hourPicker.getValue();
        min = minPicker.getValue();
        Log.i("Jacky","MainActivity:"+hours+":"+min);
        it.putExtra("hours",hours);
        it.putExtra("min",min);
        startService(it);

    }





}