package com.jikexueyuan.learnview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private RelativeLayout  myView001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView001 = (RelativeLayout) findViewById(R.id.activity_main);
        myView001.setOnTouchListener(this);


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        /*int result = event.getAction();
        if (result == MotionEvent.ACTION_DOWN){
            System.out.println("这是点击事件");
        }
        else if (result == MotionEvent.ACTION_MOVE){
            System.out.println("这是滑动事件");
            this.onTouchEvent(event);
        }
        else if (result == MotionEvent.ACTION_UP) {
            System.out.println("这是抬起事件");
        }*/

        this.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //日常开发中，我们比较常用的是onSingleTapUp（单击），onFling（快速滑动），
        //onSrcoll（拖动），onLongPress（长按）,onDoubleTap（双击）
        //此处例子中还有一个没有实现的接口onDoubleTapListener，由后人慢慢实现
        //实际开发中，我们可以不用new一个GestureDetector，我们直接使用对应的监听器就好
        GestureDetector mytestgesture = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                System.out.println("这是按下事件，由onGestureListener继承");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                System.out.println("这是按下而未进行滑动时间，由onGestureListener继承");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                /*
                    严格的单击事件：由于双击事件中的操作过程是两个单击事件的组成，所以有可能发生误判，
                    根据两个单击事件的间隔时间，提供不同的方法（函数）进行严谨的判断
                 */
                System.out.println("这是不严格的单击事件，有ACTION_UP事件触发");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                /*
                    事件构成：有一个ACTION_DOWN 和 多个 ACTION_MOVE事件组成
                */
                System.out.println("这是手指按下并拖动事件，由onGestureListener继承");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                /*
                   长久按住不放。。。。（嗯，很强势）
                 */
                System.out.println("这是长按事件，由onGestureListener继承");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                /*
                 由一个ACTION_DOWN时间，多个ACTION_MOVE 和 一个ACTION_UP事件组成
                * */
                System.out.println("这是快速滑动事件，由onGestureListener继承");
                return true;
            }
        });
        mytestgesture.setIsLongpressEnabled(false);
        boolean consume = mytestgesture.onTouchEvent(event);
        return consume;

        /*
        //尝试首次使用速度追踪器（VelocityTracker）
        VelocityTracker mytestvelocity = VelocityTracker.obtain();
        mytestvelocity.addMovement(event);
        mytestvelocity.computeCurrentVelocity(1000);//注意此处是用毫秒来为单位进行统计的，设置时间

//            注意：
//                1.此处获取的单位是速度是（像素点/时间），即每单位时间内走过屏幕多少像素点
//                2.此处获取速度是有方向的矢量，即根据Android的坐标系可推倒可知

        int now_XVelocity = (int) mytestvelocity.getXVelocity();
        int now_YVelocity = (int) mytestvelocity.getYVelocity();
        System.out.println("现在X轴的即时速度是：" +now_XVelocity );
        System.out.println("现在Y轴的即时速度是：" + now_YVelocity);
        mytestvelocity.clear();
        mytestvelocity.recycle();
        return super.onTouchEvent(event);
        */
    }
}
