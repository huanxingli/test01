package com.example.administrator.taobaotest;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaobaoTest extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private List<View> views;
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView choice1,choice2,choice3,choice4,
                      choice5,choice6,choice7,choice8,
                      shoes,vegatable,huangguan,sunglassess,
                      homepage,buy,takephoto,show,user;
    GestureDetector gestureDetector;
    private AtomicInteger atomicInteger = new AtomicInteger(0);//类似计数器的
    private ImageView[] dots;
    private int[] ids = {R.id.iv1 , R.id.iv2 , R.id.iv3,
                         R.id.iv4 , R.id.iv5 , R.id.iv6};
    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao_test);
        choice1 = (ImageView) findViewById(R.id.choice1);
        choice2 = (ImageView) findViewById(R.id.choice2);
        choice3 = (ImageView) findViewById(R.id.choice3);
        choice4 = (ImageView) findViewById(R.id.choice4);
        choice5 = (ImageView) findViewById(R.id.choice5);
        choice6 = (ImageView) findViewById(R.id.choice6);
        choice7 = (ImageView) findViewById(R.id.choice7);
        choice8 = (ImageView) findViewById(R.id.choice8);
        shoes = (ImageView) findViewById(R.id.shoes);
        vegatable = (ImageView) findViewById(R.id.vegatable);
        huangguan = (ImageView) findViewById(R.id.huangguan);
        sunglassess = (ImageView) findViewById(R.id.sunglassess);
        homepage = (ImageView) findViewById(R.id.homepage);
        buy = (ImageView) findViewById(R.id.buy);
        takephoto = (ImageView) findViewById(R.id.takephoto);
        show = (ImageView) findViewById(R.id.show);
        user = (ImageView) findViewById(R.id.user);
        //初始化滑动的视图并随时改变
        initViews();
        //初始化提示器
        initDots();

        choice1.setImageBitmap(this.getBitmap(this, R.drawable.image1));
        choice2.setImageBitmap(this.getBitmap(this, R.drawable.image2));
        choice3.setImageBitmap(this.getBitmap(this, R.drawable.image3));
        choice4.setImageBitmap(this.getBitmap(this, R.drawable.image4));
        choice5.setImageBitmap(this.getBitmap(this, R.drawable.image5));
        choice6.setImageBitmap(this.getBitmap(this, R.drawable.image6));
        choice7.setImageBitmap(this.getBitmap(this, R.drawable.image7));
        choice8.setImageBitmap(this.getBitmap(this, R.drawable.image8));
        shoes.setImageBitmap(this.getBitmap(this, R.drawable.shoes));
        vegatable.setImageBitmap(this.getBitmap(this, R.drawable.vegetable));
        huangguan.setImageBitmap(this.getBitmap(this, R.drawable.huangguan));
        sunglassess.setImageBitmap(this.getBitmap(this, R.drawable.sunglassess));
        homepage.setImageBitmap(this.getBitmap(this, R.drawable.homepage));
        buy.setImageBitmap(this.getBitmap(this, R.drawable.buy));
        takephoto.setImageBitmap(this.getBitmap(this, R.drawable.takephoto));
        show.setImageBitmap(this.getBitmap(this, R.drawable.show));
        user.setImageBitmap(this.getBitmap(this, R.drawable.user));

    }


    //获取图片
    @SuppressWarnings("ResourceType")
    public Bitmap getBitmap(Context context,int id){
        //获取图片资源
        InputStream is = null;
        try {
            is = context.getResources().openRawResource(id);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        choice3 = (ImageView) findViewById(R.id.choice3);
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        return BitmapFactory.decodeStream(is, null, opt);
    }

    public void initViews(){
        views = new ArrayList<View>();

        ImageView img1 = new ImageView(this);
        img1.setBackgroundResource(R.drawable.i1);
        views.add(img1);

        ImageView img2 = new ImageView(this);
        img2.setBackgroundResource(R.drawable.i2);
        views.add(img2);

        ImageView img3 = new ImageView(this);
        img3.setBackgroundResource(R.drawable.i3);
        views.add(img3);

        ImageView img4 = new ImageView(this);
        img4.setBackgroundResource(R.drawable.i4);
        views.add(img4);

        ImageView img5 = new ImageView(this);
        img5.setBackgroundResource(R.drawable.i5);
        views.add(img5);

        ImageView img6 = new ImageView(this);
        img6.setBackgroundResource(R.drawable.i6);
        views.add(img6);

        viewPagerAdapter = new ViewPagerAdapter(views,this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(this);

        //随时改变图片和提示器
        new Thread(){
            @Override
            public void run() {
                while (true){
                    handler.sendEmptyMessage(atomicInteger.get());
                    autoImage();
                }
            }
        }.start();

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what % views.size()==0 && (msg.what!=0)) {
                viewPager.setCurrentItem((msg.what) % views.size(),false);
                atomicInteger.set(0);
            }else{
                viewPager.setCurrentItem((msg.what) % views.size());
            }
        }
    };

    //每隔2秒切换视图
    public void autoImage(){
        atomicInteger.incrementAndGet();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void initDots(){
        dots = new ImageView[views.size()];
        for (int i=0;i<views.size();i++){
            dots[i] = (ImageView) findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<views.size();i++){
            if (position==i){
                atomicInteger.set(position);
                dots[i].setImageResource(R.drawable.point_focused);
            }else{
                dots[i].setImageResource(R.drawable.point_unfocused);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }




}
