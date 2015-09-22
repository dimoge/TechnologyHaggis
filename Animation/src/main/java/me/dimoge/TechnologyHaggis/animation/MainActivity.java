package me.dimoge.TechnologyHaggis.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    Button translateBtn, scaleBtn, rotateBtn, alphaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translateBtn = (Button) findViewById(R.id.translate_btn);
        scaleBtn = (Button) findViewById(R.id.scale_btn);
        rotateBtn = (Button) findViewById(R.id.rotate_btn);
        alphaBtn = (Button) findViewById(R.id.alpha_btn);

        translateBtn.setOnClickListener(this);
        scaleBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        alphaBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.translate_btn:
                startActivity(new Intent(MainActivity.this, TranslateActivity.class));
                break;
            case R.id.scale_btn:
                startActivity(new Intent(MainActivity.this, ScaleActivity.class));
                break;
            case R.id.rotate_btn:
                startActivity(new Intent(MainActivity.this, RotateActivity.class));
                break;
            case R.id.alpha_btn:
                startActivity(new Intent(MainActivity.this, AlpahActivity.class));
                break;
            default:
                return;
        }
    }
}
