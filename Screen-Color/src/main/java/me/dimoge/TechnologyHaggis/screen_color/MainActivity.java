package me.dimoge.TechnologyHaggis.screen_color;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    Button btn;
    LinearLayout layout;

    Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        layout = (LinearLayout) findViewById(R.id.main_layout);

        resources = getBaseContext().getResources();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.rgb(138, 138, 138));

            }
        });
    }

}
