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
 * alpha���䶯��
 * ����һ����Լ򵥵Ķ���(���������������Ƚ�)
 * ���Լ�, �����Ƚ���
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
                 * ����һ�����ڵ�ʱ��
                 */
                alphaAnimation.setDuration(3000);

                /**����ִ�к�
                 * @param true ����������,ֹͣ�ڶ��������һ��
                 * @param false ����������,�ص������״̬
                 */
                alphaAnimation.setFillAfter(true);

                /**
                 * ����fillAfter
                 */
                alphaAnimation.setFillBefore(true);

                /**��ʱִ��
                 * @param long ָ����ʱִ�е�ʱ��
                 */
                alphaAnimation.setStartOffset(1000);//�ӳ�1000����ִ��

                /**�ظ�ģʽ
                 * @param Animation.REVERSE ����һ��
                 * @param Animation.RESTART ���¿�ʼ
                 */
                alphaAnimation.setRepeatMode(Animation.REVERSE);//���¿�ʼ

                /**�ظ�����
                 * @param Animation.INFINITE ����ѭ��
                 * @param -1 ����ѭ��
                 * @param 0 һ��
                 * @param int ָ������
                 */
                alphaAnimation.setRepeatCount(Animation.INFINITE);

                img.startAnimation(alphaAnimation);//��ʼ����

                /**
                 * ������ԶԶ����Ŀ�ʼ, ����, �ظ� �����¼�����
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
     * ͨ��xml���õķ�ʽ����alpha����
     * xml����ͬ���������ø�������, ��û�в�ͬ
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
