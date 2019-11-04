package com.technoboy.loginsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView attempts;
    Button login;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        login=findViewById(R.id.button);
        checkBox=findViewById(R.id.checkBox);

        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences=getSharedPreferences("LoginDetails",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();

                        if(username.getText().length()==0){
                            username.setError("Username cannot be Blank");
                        }
                        else if(password.getText().length()==0){
                            password.setError("Password cannot be Blank");
                        }
                        else{
                            if(username.getText().toString().equals("technoboy") && password.getText().toString().equals("technoboy")){
                                if(checkBox.isChecked()){
                                    editor.putString("username",username.getText().toString());
                                    editor.putString("password",password.getText().toString());
                                    editor.commit();
                                }
                                Intent intent=new Intent(MainActivity.this,Welcome.class);
                                startActivity(intent);
                            }
                        }
                    }
                }
        );
    }
}
