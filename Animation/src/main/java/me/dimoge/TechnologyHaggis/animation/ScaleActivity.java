package me.dimoge.TechnologyHaggis.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by dime on 2015/9/22 0022.
 */
public class ScaleActivity extends Activity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**构造方法详解 共6个参数 详情参见rotateAnimation, 不再做解释
                 * @param fromX 开始大小 float
                 * @param toX 结束大小 float
                 * @param fromY 开始大小 float
                 * @param toY 结束大小 float
                 * @param povitX 位置
                 * @param float
                 * @param povitY 位置
                 * @param float
                 */
                Animation scaleAnimation = new ScaleAnimation(1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(3000);//执行时间
                scaleAnimation.setFillAfter(true);//...
                scaleAnimation.setFillBefore(true);//...
                scaleAnimation.setRepeatMode(Animation.RESTART);//...
                scaleAnimation.setRepeatCount(Animation.INFINITE);//无限重复...
                LinearInterpolator li = new LinearInterpolator();
                scaleAnimation.setInterpolator(li);//匀速....
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                img.startAnimation(scaleAnimation);
            }
        });
    }

    /**
     * 通过xml配置实现伸缩动画, 并没有什么不同, 详见rotateAnimation
     */
    private void SCALE_XML(){
        Animation scaleAnimation = AnimationUtils.loadAnimation(ScaleActivity.this, R.anim.animation_scale);
        img.startAnimation(scaleAnimation);
    }
}
