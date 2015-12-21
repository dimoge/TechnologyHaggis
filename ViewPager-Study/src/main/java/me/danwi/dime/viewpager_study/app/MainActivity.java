package me.danwi.dime.viewpager_study.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends Activity {


    ViewPager viewPager;
    List<Integer> bg = new ArrayList<Integer>();
    List<View> views = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg.add(R.mipmap.book_zoo);
        bg.add(R.mipmap.button_back);
        bg.add(R.mipmap.button_back_pressed);
        bg.add(R.mipmap.button_pressed);
        bg.add(R.mipmap.camera_button);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        for(int i=0; i<5 ; i++ ){
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setBackgroundResource(bg.get(i));
            views.add(imageView);
        }
        viewPager.setAdapter(pagerAdapter);
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onnononono");
    }
}
