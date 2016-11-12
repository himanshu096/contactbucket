package ga.himanshu.home.contactbucket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usernameInput;
    EditText paswordInput;
    Button login;
    String $UserName="himanshu";
    String $Password="sourav";
    int l1;
    int l2;
    String l1Input;
    String l2Input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput=(EditText)findViewById(R.id.username_input);
        paswordInput=(EditText)findViewById(R.id.password_input);
        login=(Button)findViewById(R.id.submit_button);
        login.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        l1=usernameInput.getText().length();
        l2=paswordInput.getText().length();
        l1Input=usernameInput.getText().toString();
        l2Input=paswordInput.getText().toString();

        if(l1 >= 4 && l2>= 4){
            if(l1Input .equals($UserName)&&l2Input.equals($Password) ){

                Intent i = new Intent(this, Main2Activity.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "Ohho..you entered Wrong Credential dear!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Sorry Entered Format is not Correct", Toast.LENGTH_SHORT).show();
        }
    }
}
