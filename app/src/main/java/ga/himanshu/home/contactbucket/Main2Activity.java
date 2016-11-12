package ga.himanshu.home.contactbucket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button addcontact;
    Button viewcontact;
    Button addmemo;
    Button viewmemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addcontact=(Button)findViewById(R.id.add_contact);
        viewcontact=(Button)findViewById(R.id.view_contact);
        addmemo=(Button)findViewById(R.id.add_memo);
        viewmemo=(Button)findViewById(R.id.view_memo);
        addcontact.setOnClickListener(this);
        viewmemo.setOnClickListener(this);
        addmemo.setOnClickListener(this);
        viewcontact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.add_contact){
            Intent i = new Intent(this,AddActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.view_contact){
            Intent i =new Intent(this,ViewActivity.class);
            startActivity(i);
        }
    }
}
