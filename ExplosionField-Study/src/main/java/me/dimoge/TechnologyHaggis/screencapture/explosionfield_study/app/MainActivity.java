package me.dimoge.TechnologyHaggis.screencapture.explosionfield_study.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import tyrantgit.explosionfield.ExplosionField;


public class MainActivity extends Activity {

    ExplosionField explosionField;

    ImageView one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explosionField = ExplosionField.attach2Window(this);

        one = (ImageView) findViewById(R.id.one);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explosionField.explode(one);
                one.setOnClickListener(null);
            }
        });

    }


}
