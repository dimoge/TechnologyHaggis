package me.dimoge.TechnologyHaggis;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button zxing_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zxing_btn = (Button) findViewById(R.id.zxing_btn);
        zxing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCameraIntent = new Intent(MainActivity.this,ZXingActivity.class);
                startActivityForResult(openCameraIntent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //����ɨ�������ڽ�������ʾ��
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Log.d("��ά��====[", scanResult+"]");
        }
    }



}
