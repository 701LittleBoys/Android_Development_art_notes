package layout_animation_001.edu.imufe.com.learn_layoutanimation_001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> listAdapter;
    private ListView listView;
    private String[] datalist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.my_listview_001);

        datalist = new String[100];


        //进行填充数据


        for (Integer i = 1; i<=100 ; i++){
            datalist[i] = i.toString();
            System.out.println("打印数据" + datalist[i]);
        }
        //设置Adapter
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                datalist);


        listView.setAdapter(listAdapter);


        Animation my_animation = AnimationUtils.loadAnimation(this,R.anim.anim_item_001);
        listView.startAnimation(my_animation);



    }
}
