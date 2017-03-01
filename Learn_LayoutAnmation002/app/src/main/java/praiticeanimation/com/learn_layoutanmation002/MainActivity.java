package praiticeanimation.com.learn_layoutanmation002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button my_button_001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.my_button_001 = (Button) findViewById(R.id.my_bt_001);

        this.my_button_001.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.my_bt_001){
            startActivity(new Intent(this,Main2Activity.class));
            overridePendingTransition(R.anim.enter_anim_001,R.anim.exit_anim_001);
        }
    }
}
