package me.dimoge.TechnologyHaggis.animation;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;

/**
 * rotateAnimation 旋转动画
 * 需要注意的是 旋转中心点, 旋转速度(加速, 减速, 匀速)
 * Created by dime on 2015/9/22 0022.
 */
public class RotateActivity extends Activity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);

        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**RotateAnimation 构造方法 共6个参数
                 * @param fromDegree 开始旋转角度 float[0f-360f]
                 * @param toDegree 结束旋转角度 float[0f-360f]
                 * @param X相对位置 Anmiation.RELATIVE_TO_SELF | Animation.RELATIVE_TO_PARENT
                 * @param pivoteX 圆形X坐标 float[0f-1f]
                 * @param Y相对位置 Anmiation.RELATIVE_TO_SELF | Animation.RELATIVE_TO_PARENT
                 * @param pivoteY 圆形Y坐标 float[0f-1f]
                 */
                RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);//0.5代表中心点
                rotateAnimation.setDuration(3000);//详细可参见alphaAnimation
                rotateAnimation.setRepeatMode(Animation.RESTART);//重新开始 同上
                rotateAnimation.setRepeatCount(Animation.INFINITE);//无限重复 同上
                rotateAnimation.setFillAfter(true);//停止, 处于动画结束的最后一帧
                rotateAnimation.setFillBefore(true);//.....

                /**设置速度
                 * @param Interpolator 动画速率变化的控制
                 * 九种速率控制, 说明如下
                 */
                LinearInterpolator li = new LinearInterpolator();//匀速
                AccelerateDecelerateInterpolator adli = new AccelerateDecelerateInterpolator();//在动画结束和开始的地方速率改变比较慢, 在中间的时候加速
                AccelerateInterpolator ali = new AccelerateInterpolator();//在动画开始的地方速率改变比较慢, 然后开始加速
                CycleInterpolator cli = new CycleInterpolator(10);//动画循环特定的次数, 速率改变沿正玄曲线(需要指定动画循环次数)
                DecelerateInterpolator dli = new DecelerateInterpolator();//在动画开始的地方速率改变比较慢, 然后开始减速
                AnticipateInterpolator anticipateInterpolator = new AnticipateInterpolator();//反向 ，先向相反方向改变一段再加速播放
                AnticipateOvershootInterpolator aoi = new AnticipateOvershootInterpolator();// 反向加回弹，先向相反方向改变，再加速播放，会超出目的值然后缓慢移动至目的值
                BounceInterpolator bi = new BounceInterpolator();//跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，80，90，100
                OvershootInterpolator osi = new OvershootInterpolator();//回弹，最后超出目的值然后缓慢改变到目的值
                TimeInterpolator timeInterpolator = new TimeInterpolator() {
                    @Override
                    public float getInterpolation(float input) {
                        return 0;
                    }
                };//一个接口，允许你自定义interpolator，以上几个都是实现了这个接口

                rotateAnimation.setInterpolator(aoi);

                img.startAnimation(rotateAnimation);
            }
        });
    }

    /**
     *  通过xml配置的方式, 实现rotate旋转动画
     *  不同的是, 通过xml配置速度的话, 要在set中写, 而不是在<rotate ./> 中, 否则不会起作用!!!!
     */
    private void XML_ROTATE(){
        Animation rotateAnimation = AnimationUtils.loadAnimation(RotateActivity.this, R.anim.animation_rotate);
        img.startAnimation(rotateAnimation);
    }
}
