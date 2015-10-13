package me.dimoge.TechnologyHaggis.screencapture.window_ball;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by dime on 2015/10/13 0013.
 */
public class LocalServer extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("local-server:"," server onBind");
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("local-server", "server onStart");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("local-server", "server onCreate");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("local-server", "server onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("local-server", "server onDestroy");
    }
}
