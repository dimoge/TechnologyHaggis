package me.dimoge.TechnologyHaggis.camerasys;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity {

    Button btn, btn2;
    ImageView img;

    String BASEPAHT = "/sdcard/TechnologyHaggis/CameraSys/";
    String dataStr;

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
//                    指定照片存储的地址
//                    File file = new File("/sdcard/TechnologyHaggis/CameraSys/1.jgp");
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                    startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX",1);
                intent.putExtra("aspectY",1);
                intent.putExtra("outputX", 80);
                intent.putExtra("outputY", 80);
                intent.putExtra("return-data",true);
                startActivityForResult(intent, 11);
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
                File file = new File(BASEPAHT);
                file.mkdirs();// 创建文件夹，名称为myimage

                Date date=null;
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前时间，进一步转化为字符串
                date =new Date();
                dataStr=format.format(date);
                String fileName = BASEPAHT+dataStr+".jpg";
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
                //开始裁剪
                Intent intentCat = new Intent("com.android.camera.action.CROP");
                File f = new File(BASEPAHT+dataStr+".jpg");
                intentCat.setDataAndType(Uri.fromFile(f), "image/*");
                // aspectX aspectY 是宽高的比例
                intentCat.putExtra("aspectX", 1);
                intentCat.putExtra("aspectY", 1);
                startActivityForResult(intentCat, 3);
            }else{
                Toast.makeText(MainActivity.this, "没有可用的sd卡", Toast.LENGTH_SHORT).show();
            }
        }else{//失败
            Toast.makeText(MainActivity.this, "拍照失败", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
