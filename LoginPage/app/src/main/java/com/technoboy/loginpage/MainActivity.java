package com.technoboy.loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.SharedPreferences.*;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView attempts;
    Button login;
    int counter=3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        login=findViewById(R.id.button);
        attempts=findViewById(R.id.textView2);
        attempts.setText("No. of Attempts Remaining : "+counter);
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().length()==0){
                            username.setError("Username cannot be Blank");
                        }
                        else if(password.getText().length()==0){
                            password.setError("Password cannot be Blank");
                        }
                        else{
                            if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                                Intent intent=new Intent(MainActivity.this,Welcome.class);
                                startActivity(intent);
                            }
                            else
                            {
                                counter--;
                                attempts.setText("No. of Attempts Remaining : "+counter);
                                if(counter==0){
                                    login.setEnabled(false);
                                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                                    builder.setMessage("Invalid Login Details")
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();
                                                }
                                            })
                                    .show();
                                }
                            }
                        }
                    }
                }
        );
    }
}
