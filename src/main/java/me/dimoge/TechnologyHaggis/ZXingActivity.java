package me.dimoge.TechnologyHaggis;

import android.os.Bundle;
import com.journeyapps.barcodescanner.CaptureActivity;

/**
 * Created by dime on 2015/8/26 0026.
 */
public class ZXingActivity extends CaptureActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);
    }
}
