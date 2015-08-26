package me.dimoge.TechnologyHaggis;

import android.app.Activity;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;


/**
 * Created by dime on 2015/8/26 0026.
 */
public class ZXingActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 保持Activity处于唤醒状态
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_zxing);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
