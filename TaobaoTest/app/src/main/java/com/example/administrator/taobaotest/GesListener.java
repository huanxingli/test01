package com.example.administrator.taobaotest;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2015/9/9.
 */
public class GesListener implements GestureDetector.OnGestureListener ,View.OnTouchListener{
    @Override
    public boolean onDown(MotionEvent e) {
        System.out.println("-------onDown-------");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        System.out.println("-------onShowPress-------");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("-------onSingleTapUp-------");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("-------onLongPress-------");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("-------onFling-------");
        //从左往右滑动(左进右出)
        if (e2.getX() - e1.getX() > 50){
            System.out.println("--------左进右出-------");
        }else if (e2.getX()-e1.getX()<-50){ //右进左出
            System.out.println("-------右进左出-------");
            return true;
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println("123");
        return true;
    }
}
