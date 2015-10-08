package me.dimoge.TechnologyHaggis.camerasys;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity {

    Button btn, btn2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PackageManager packageManager = this.getPackageManager();

        btn = (Button) findViewById(R.id.btn);//相机按钮
        btn2 = (Button) findViewById(R.id.btn2);//相册按钮
        img = (ImageView) findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA) == false){
                    Toast.makeText(MainActivity.this, "系统没有相机", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1);
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode==Activity.RESULT_OK){//成功
            Bundle bundle = data.getExtras();//拿到数据
            Bitmap bitmap = (Bitmap) bundle.get("data");
            img.setImageBitmap(bitmap);

            String sdStatus = Environment.getExternalStorageState();
            if(sdStatus.equals(Environment.MEDIA_MOUNTED)){//有sd卡
                FileOutputStream b = null;
                File file = new File("/sdcard/TechnologyHaggis/CameraSys/");
                file.mkdirs();// 创建文件夹，名称为myimage

                String str=null;
                Date date=null;
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前时间，进一步转化为字符串
                date =new Date();
                str=format.format(date);
                String fileName = "/sdcard/TechnologyHaggis/CameraSys/"+str+".jpg";
                try {
                    b = new FileOutputStream(fileName);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        b.flush();
                        b.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                Toast.makeText(MainActivity.this, "没有可用的sd卡", Toast.LENGTH_SHORT).show();
            }
        }else{//失败
            Toast.makeText(MainActivity.this, "拍照失败", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
