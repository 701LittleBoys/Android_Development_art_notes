package imooc.com.learn_arrtibute_animation003;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button my_bt_001;
    private ImageView my_iv_001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_bt_001 = (Button) findViewById(R.id.my_bt_001);
        my_iv_001 = (ImageView) findViewById(R.id.my_iv_001);

        my_bt_001.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int result = v.getId();
        if (result == R.id.my_bt_001){
            //对ImageVIew进行控制
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(my_iv_001,"translationX",0,500);
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(my_iv_001,"translationY",0,200);

            //对Button进行控制
            ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(my_bt_001,"rotation",0,360);

            AnimatorSet animatorSet = new AnimatorSet();

            /*
                同时播放动画：play() ..... with ()
                顺序播放动画：play() ..... after ()
                之前播放动画：play() ..... before ()
             */

            //animatorSet：将所有Animator对象塞入集合当中

            animatorSet.setDuration(1000);
            //animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
            animatorSet.playSequentially(objectAnimator1,objectAnimator2,objectAnimator3);
            animatorSet.setStartDelay(1000);
            animatorSet.start();

            /*
                一个完整的动画效果，是通过多个动画，按照一定顺序，组合在一起的
                AnimatorSet可以自动驱动动画，是一个非常好的Set类
             */


        }
    }
}
