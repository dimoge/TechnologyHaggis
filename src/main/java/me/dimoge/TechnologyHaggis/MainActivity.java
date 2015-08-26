package me.dimoge.TechnologyHaggis;


import android.os.Bundle;
import com.journeyapps.barcodescanner.CaptureActivity;


public class MainActivity extends CaptureActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
    }



}
