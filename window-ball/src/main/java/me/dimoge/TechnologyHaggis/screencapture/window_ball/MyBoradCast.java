package me.dimoge.TechnologyHaggis.screencapture.window_ball;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by dime on 2015/10/13 0013.
 */
public class MyBoradCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MyBoradCast onReceive", Toast.LENGTH_SHORT).show();
        Log.i("myboradcast","broadcast onReceive");
    }

}
