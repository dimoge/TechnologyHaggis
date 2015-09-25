package me.dimoge.TechnologyHaggis.http;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity {

    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String urlPathContent = "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690";
                try {
                    byte[] data = getImage(urlPathContent);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);  //生成位图
                    img.setImageBitmap(bitmap);   //显示图片
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "c出错了啊", Toast.LENGTH_LONG).show();  //通知用户连接超时信息
                    Log.i("xxxx", e.toString());
                }

            }
        });
    }

    public static byte[] getImage(String path) throws IOException {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");   //设置请求方法为GET
        conn.setReadTimeout(5*1000);    //设置请求过时时间为5秒
        InputStream inputStream = conn.getInputStream();   //通过输入流获得图片数据
        byte[] data = readInputStream(inputStream);     //获得图片的二进制数据
        return data;

    }

    /*
    * 从数据流中获得数据
    */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();

    }


}
