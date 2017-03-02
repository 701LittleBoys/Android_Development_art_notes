package imooc.com.learn_attribute_animation002;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        this.my_bt_001 = (Button) findViewById(R.id.my_bt_001);
        this.my_iv_001 = (ImageView) findViewById(R.id.my_iv_001);

        my_bt_001.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int result = v.getId();
        if (result == R.id.my_bt_001){
            PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation",0,360);
            PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX",0,300);
            PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY",0,300);
            ObjectAnimator.ofPropertyValuesHolder(my_iv_001,p1,p2,p3)
                    .setDuration(1000)
                    .start();
        }
    }
}
