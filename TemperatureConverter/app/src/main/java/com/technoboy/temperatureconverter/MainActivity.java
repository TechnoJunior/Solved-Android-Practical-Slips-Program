package com.technoboy.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText temp;
    Button ftc,ctf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp=findViewById(R.id.editText);
        ftc=findViewById(R.id.button);
        ctf=findViewById(R.id.button2);


        ftc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double temperature=Integer.parseInt(temp.getText().toString());
                        Double b=temperature-32;
                        Double c=b*5/9;
                        String r=String.valueOf(c);
                        Toast.makeText(MainActivity.this,r+"°C",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        ctf.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double temperature=Integer.parseInt(temp.getText().toString());
                        Double b=temperature*9/5+32;
                        String r=String.valueOf(b);
                        Toast.makeText(MainActivity.this,r+"°F",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
