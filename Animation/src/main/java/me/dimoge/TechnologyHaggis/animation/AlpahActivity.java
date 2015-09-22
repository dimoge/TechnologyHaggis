package me.dimoge.TechnologyHaggis.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * alpha渐变动画
 * 这是一个相对简单的动画(与其他三个动画比较)
 * 属性简单, 动作比较少
 * Created by dime on 2015/9/22 0022.
 */
public class AlpahActivity extends Activity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);

        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);

                /**
                 * 动画一个周期的时间
                 */
                alphaAnimation.setDuration(3000);

                /**动画执行后
                 * @param true 动画结束后,停止在动画的最后一刻
                 * @param false 动画结束后,回到最初的状态
                 */
                alphaAnimation.setFillAfter(true);

                /**
                 * 类似fillAfter
                 */
                alphaAnimation.setFillBefore(true);

                /**延时执行
                 * @param long 指定延时执行的时间
                 */
                alphaAnimation.setStartOffset(1000);//延迟1000毫秒执行

                /**重复模式
                 * @param Animation.REVERSE 倒播一次
                 * @param Animation.RESTART 重新开始
                 */
                alphaAnimation.setRepeatMode(Animation.REVERSE);//重新开始

                /**重复次数
                 * @param Animation.INFINITE 无线循环
                 * @param -1 无线循环
                 * @param 0 一次
                 * @param int 指定次数
                 */
                alphaAnimation.setRepeatCount(Animation.INFINITE);

                img.startAnimation(alphaAnimation);//开始动画

                /**
                 * 这里可以对动画的开始, 结束, 重复 进行事件监听
                 */
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
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
            }
        });
    }

    /**
     * 通过xml配置的方式配置alpha动画
     * xml配置同样可以设置各种属性, 并没有不同
     */
    private void XML_ALPHA() {
        Animation alphaAnimation = AnimationUtils.loadAnimation(AlpahActivity.this, R.anim.animation_alpha);
        img.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
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
    }
}
