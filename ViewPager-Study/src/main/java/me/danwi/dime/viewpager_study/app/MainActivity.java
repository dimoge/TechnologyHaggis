package me.danwi.dime.viewpager_study.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        LinearLayout linearLayout = new LinearLayout(this);

        bg.add(R.layout.item_one);
        bg.add(R.layout.item_two);
        bg.add(R.layout.item_three);
        bg.add(R.layout.item_four);
        bg.add(R.layout.item_five);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        for(int i=0; i<5 ; i++ ){
            View view  = LayoutInflater.from(MainActivity.this).inflate(bg.get(i),null);
            views.add(view);
        }
        viewPager.setAdapter(pagerAdapter);
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view==o;
        }

        @Override
        public int getCount() {
            return -1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(views.get(position%5));
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "title";
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position%5));

            return views.get(position%5);
        }
    };
}
