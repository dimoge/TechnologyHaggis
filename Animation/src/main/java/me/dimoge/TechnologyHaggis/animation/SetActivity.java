package me.dimoge.TechnologyHaggis.animation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by dime on 2015/9/23 0023.
 */
public class SetActivity extends Activity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 将一些列动画放到动画集合中, 一起执行
                 * 如下效果 : 旋转的同时透明度改变
                 */
                AnimationSet set = new AnimationSet(true);

                Animation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(3000);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                Animation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatMode(Animation.RESTART);
                alphaAnimation.setRepeatCount(Animation.INFINITE);

                set.addAnimation(rotateAnimation);
                set.addAnimation(alphaAnimation);

                img.startAnimation(set);
//                Object_Animaiton();
            }
        });
    }

    private void Object_Animaiton(){
        ObjectAnimator.ofFloat(img, "rotationX", 0, 360).setDuration(3000).start();
    }
}
