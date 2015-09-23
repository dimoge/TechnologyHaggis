package me.dimoge.TechnologyHaggis.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by dime on 2015/9/22 0022.
 */
public class TranslateActivity extends Activity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * TranslateAnimation 构造函数相对特别 8参数, 4参数
                 * 下面以8个参数为例, 而4参数是不包含相对位置的, 只有坐标, 默认为RELATIVE_TO_SELF
                 *                                              相对位置开始X             X坐标       相对位置X结束  X坐标     相对位置Y开始       Y坐标     相对位置Y结束         Y坐标
                 */
                Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1);
                animation.setDuration(3000);
                animation.setFillAfter(true);
                animation.setFillBefore(true);
                animation.setStartOffset(1000);
                animation.setRepeatMode(Animation.RESTART);
                animation.setRepeatCount(Animation.INFINITE);
                LinearInterpolator li = new LinearInterpolator();
                animation.setInterpolator(li);
                img.startAnimation(animation);
            }
        });
    }

    /**
     * 移动动画的xml配置, 并没有什么不同, 耶耶耶!!!!!!
     */
    private void TRANSLATE_XML(){
        Animation translateAnim = AnimationUtils.loadAnimation(TranslateActivity.this, R.anim.animation_translate);
        img.startAnimation(translateAnim);
    }
}
