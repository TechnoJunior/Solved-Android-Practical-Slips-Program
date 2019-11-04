package com.technoboy.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add,sub,div,mul;
    EditText no1,no2;
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.button);
        sub=findViewById(R.id.button2);
        mul=findViewById(R.id.button3);
        div=findViewById(R.id.button4);

        no1=findViewById(R.id.editText);
        no2=findViewById(R.id.editText2);

        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1= Integer.parseInt(no1.getText().toString());
                        num2=Integer.parseInt(no2.getText().toString());
                        Toast.makeText(MainActivity.this, "Addition : "+ (num1 + num2), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        sub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1= Integer.parseInt(no1.getText().toString());
                        num2=Integer.parseInt(no2.getText().toString());
                        Toast.makeText(MainActivity.this, "Subtraction : "+ (num1 - num2), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        mul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1= Integer.parseInt(no1.getText().toString());
                        num2=Integer.parseInt(no2.getText().toString());
                        Toast.makeText(MainActivity.this, "Multiplication : "+ (num1 * num2), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1= Integer.parseInt(no1.getText().toString());
                        num2=Integer.parseInt(no2.getText().toString());
                        Toast.makeText(MainActivity.this, "Division : "+ (num1 / num2), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
