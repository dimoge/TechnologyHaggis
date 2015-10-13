package me.dimoge.TechnologyHaggis.screencapture.screen_capture_other;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;


public class MainActivity extends Activity {

    private ScreenRecoder mDisplaySourceService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplaySourceService = new ScreenRecoder(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopServices();
    }

    private void startServices() {

        mDisplaySourceService.start("/sdcard/avideo.mp4");
    }

    private void stopServices() {
        if (mDisplaySourceService != null && mDisplaySourceService.isStarted()) {
            mDisplaySourceService.stop();
            mDisplaySourceService = null;
        }
    }

    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            startServices();
        } else {
            stopServices();
        }
    }


}
