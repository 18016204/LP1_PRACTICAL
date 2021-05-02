package sg.edu.rp.c346.id18016204.lp1practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    taskAdapter aa;
    ArrayList<Task> dca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lvPractical);


        dca=new ArrayList<Task>();
dca.add(new Task("Group Discussion ", "1 May 2021"));
        dca.add(new Task("Assignment submission", "5 May 2021"));
        dca.add(new Task("Online course ", "19 Jun 2021"));

aa=new taskAdapter(this,R.layout.row_task,dca);
lv.setAdapter(aa);



    }
}