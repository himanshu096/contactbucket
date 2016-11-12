package ga.himanshu.home.contactbucket;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    Button savebutton;
    EditText emailinput;
    EditText contactinput;
    EditText nameinput;
    TextView titleview;
    String name;
    String email;
    int contact;
    int el1;
    int nl2;
    int cl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        savebutton=(Button)findViewById(R.id.save_button);
        savebutton.setOnClickListener(this);

        emailinput=(EditText)findViewById(R.id.email_input);
        contactinput=(EditText)findViewById(R.id.contact_input);
        nameinput=(EditText)findViewById(R.id.name_input);
    }

    @Override
    public void onClick(View v) {
        el1=emailinput.getText().length();
        nl2=nameinput.getText().length();
        cl3=contactinput.getText().length();
        name=nameinput.getText().toString();
        email=emailinput.getText().toString();
        contact= ((int) contactinput.getAlpha());

        if (nl2 >= 3 && cl3>=10){

            DataBaseHelper dbHelper=new DataBaseHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values= new ContentValues();
            values.put("name",name);
            values.put("email",email);
            values.put("contact",contact);


            long id = db.insert(DataBaseHelper.CONTACT_TABLE, null, values);
            Toast.makeText(this,"your Contact is saved at id"+ id,Toast.LENGTH_SHORT).show();
            finish();



        }
        else {
            Toast.makeText(this, "Sorry we can't save your contact", Toast.LENGTH_SHORT).show();
        }



    }
}
