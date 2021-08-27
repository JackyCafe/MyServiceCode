package com.ian.myservicecode;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Swe extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int hours = intent.getIntExtra("hours",0);
        int min = intent.getIntExtra("min",0);
        Log.i("Jacky",hours+":"+min);

        return super.onStartCommand(intent, flags, startId);

    }
}
