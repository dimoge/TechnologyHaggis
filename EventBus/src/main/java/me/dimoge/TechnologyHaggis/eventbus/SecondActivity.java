package me.dimoge.TechnologyHaggis.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import de.greenrobot.event.EventBus;

/**
 * Created by dime on 2015/10/9 0009.
 */
public class SecondActivity extends Activity {

    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final FirstEvent firstEvent = new FirstEvent("guodabao");

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(firstEvent);
            }
        });
    }

}
