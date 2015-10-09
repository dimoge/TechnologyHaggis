package me.dimoge.TechnologyHaggis.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import de.greenrobot.event.EventBus;


public class MainActivity extends Activity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        EventBus.getDefault().register(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    public void onEventMainThread(FirstEvent firstEvent){
        Toast.makeText(MainActivity.this, "事件走起"+firstEvent.getMsg(), Toast.LENGTH_SHORT).show();
    }

}
