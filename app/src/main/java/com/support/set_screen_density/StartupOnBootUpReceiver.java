package com.support.set_screen_density;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;

import masonamerica.platform.MasonFramework;
import masonamerica.platform.WindowManagerPrivileged;

public class StartupOnBootUpReceiver extends BroadcastReceiver {
    private WindowManagerPrivileged windowmanager;
    private WallpaperManager wallpaperManager;

    @SuppressLint("ResourceType")
    @Override
    public void onReceive(Context context, Intent intent) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);

        Log.i("Screen Density", "Broadcast Received");
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            try {
                // set the wallpaper by calling the setResource function and
                // passing the drawable file
                wallpaperManager.setResource(R.drawable.vial_wallpaper);
            } catch (IOException e) {
                // here the errors can be logged instead of printStackTrace
                e.printStackTrace();
            }

            // set screen density
            windowmanager = MasonFramework.get(context, WindowManagerPrivileged.class);
            windowmanager.setForcedDisplayDensity(240);
        }
    }
}