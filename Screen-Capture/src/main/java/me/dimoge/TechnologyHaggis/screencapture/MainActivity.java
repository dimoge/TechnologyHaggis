package me.dimoge.TechnologyHaggis.screencapture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {
    LinearLayout main_layout;
    Button btn_start;
    Button btn_end;
    ImageView img;

    List<Bitmap> bitmaps = new ArrayList<Bitmap>();
    String BASE_PATH = "/sdcard/avideo/";
    FileOutputStream fileOutputStream = null;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bitmap = takeScreenShot(main_layout);
            bitmaps.add(bitmap);
            try {
                fileOutputStream = new FileOutputStream(BASE_PATH + bitmaps.size()+".jpg");
                bitmaps.get(bitmaps.size()-1).compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            img.setImageBitmap(bitmaps.get(bitmaps.size() - 1));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_end = (Button) findViewById(R.id.btn_end);
        img = (ImageView) findViewById(R.id.play_iv);
        main_layout = (LinearLayout) findViewById(R.id.main_layout);

        /**
         * 开始录制
         * 获取一组图片
         */
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleAnimation = new ScaleAnimation(1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(3000);//执行时间
                scaleAnimation.setFillAfter(true);//...
                scaleAnimation.setFillBefore(true);//...
                scaleAnimation.setRepeatMode(Animation.RESTART);//...
                scaleAnimation.setRepeatCount(0);//无限重复...
                btn_start.startAnimation(scaleAnimation);

                final Timer timer = new Timer();
                timer.schedule(timerTask, 0, 500);//1秒执行一次

                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        timer.cancel();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

        /**
         * 结束录制
         */
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmaps.get(0)==bitmaps.get(1)){
                    Toast.makeText(MainActivity.this, "==========", Toast.LENGTH_SHORT).show();
                }

/**
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                AnimatedGifEncoder encoder = new AnimatedGifEncoder();
                encoder.start(bos);
                for (int i=0 ; i<7 ; i++) {
                    encoder.setDelay(500);//播放间隔 0.5秒
                    encoder.addFrame(BitmapFactory.decodeFile(BASE_PATH + i + ".jpg"));//添加帧
                }
                encoder.finish();
                byte[] bytes =  bos.toByteArray();

                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(BASE_PATH + "aaa.gif");
                    fileOutputStream.write(bytes);
                    fileOutputStream.close();
                    fileOutputStream.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
*/

            }
        });

    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
        }
    };


    /**
     * 截图
     * @param view
     * @return
     */
    private Bitmap takeScreenShot(View view) {

        //View是你需要截图的View
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }
}