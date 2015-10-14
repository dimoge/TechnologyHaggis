package me.dimoge.TechnologyHaggis.screencapture.valueanimation_study.app;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    Button btn;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) btn.getLayoutParams();

        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0);
        valueAnimator.setDuration(5000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i("valueAnimation", "==============================="+count);

                params.topMargin = count;
                btn.setLayoutParams(params);
                count++;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.start();
            }
        });


    }

}
