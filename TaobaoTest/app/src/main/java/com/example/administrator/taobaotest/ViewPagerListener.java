package com.example.administrator.taobaotest;

import android.support.v4.view.ViewPager;

/**
 * Created by Administrator on 2015/9/13.
 */
public class ViewPagerListener implements ViewPager.OnPageChangeListener {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==TaobaoTest.views.size()-1){
            TaobaoTest.atomicInteger.set(position);
            TaobaoTest.dots[position-1].setImageResource(R.drawable.point_unfocused);
            TaobaoTest.dots[1].setImageResource(R.drawable.point_focused);
            System.out.println("----------1");
        }
        else{
            for (int i=1;i<TaobaoTest.views.size()-1;i++){
                if (position==i){
                    TaobaoTest.atomicInteger.set(position);
                    TaobaoTest.dots[i].setImageResource(R.drawable.point_focused);
                }else{
                    TaobaoTest.dots[i].setImageResource(R.drawable.point_unfocused);
                }
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
