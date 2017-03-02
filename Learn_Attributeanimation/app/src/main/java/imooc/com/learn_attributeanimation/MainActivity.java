package imooc.com.learn_attributeanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button my_bt_001;
    private ImageView my_iv_001;
    private Context myContext;

    public void init (Context context){
        this.myContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_bt_001 = (Button) findViewById(R.id.my_bt001);
        my_iv_001 = (ImageView) findViewById(R.id.my_iv001);

        my_bt_001.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int result = v.getId();
        if (result == R.id.my_bt001)
        {
            ObjectAnimator objectAnimator = ObjectAnimator
                    .ofFloat(my_iv_001,"rotation",0f,360f);
            objectAnimator.setDuration(1000).start();
        }
    }
}
