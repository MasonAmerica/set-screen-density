package com.support.set_screen_density;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import masonamerica.platform.MasonFramework;
import masonamerica.platform.WindowManagerPrivileged;

public class StartupOnBootUpReceiver extends BroadcastReceiver {
    private WindowManagerPrivileged windowmanager;


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Screen Density", "Broadcast Received");
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            // set screen density
            windowmanager = MasonFramework.get(context, WindowManagerPrivileged.class);
            windowmanager.setForcedDisplayDensity(240);
        }
    }
}