package com.danwi.buildtypetest.app;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationInfo info = null;
        try {
            info = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String cId = info.metaData.getString("channelName");
        Toast.makeText(MainActivity.this, "当前渠道ｉｄ是："+cId, Toast.LENGTH_LONG).show();
    }


}
