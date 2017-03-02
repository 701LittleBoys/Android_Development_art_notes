package imooc.com.learn_animationlistence001;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        //, Animator.AnimatorListener
{

    private Button my_bt_001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_bt_001 = (Button) findViewById(R.id.my_bt_001);
        my_bt_001.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int result = v.getId();
        if (result == R.id.my_bt_001){
            //设置控制对象 ：View
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(v,"alpha",0,1);

            objectAnimator1.setDuration(1000);
            /*
                如何为动画设置监听事件？
                    调用Animator.addListener()方法
             */
           // objectAnimator1.addListener(this);
            /**
             * 注意此处，我们通过AnimatorListenerAdapter适配器，
             * 找出我们想要实现的方法，把我们不必要实现的方法，
             * 通通隐藏起来
             */
            objectAnimator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    Toast.makeText(MainActivity.this, "通过动画监听器适配器，确认动画播放结束",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });

            objectAnimator1.start();
        }
    }


    /**
     * 此处需要结合《Android 开发艺术探索》来查看一定源码
     *
     *  AnimationListener是一个抽象的接口，接口里面实现方法：
     *      1.监听动画开始
     *      2.监听动画结束
     *      3.监听动画取消
     *      4.监听动画重复
     *
     * 但是，我们有时候不必要实现这么多的Animation的方法，
     * 我们可以用AnimationListenerAdapter监听器
     */
    /*
    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Toast.makeText(MainActivity.this,"动画 播放 结束",Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
    */
}
