package com.technoboy.activityoverloading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        editText=findViewById(R.id.edittext1);

        btn1.setOnClickListener(btnListner);
        btn2.setOnClickListener(btnListner);
        editText.setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        Toast.makeText(getBaseContext(), v.getId()+" has focus "+ hasFocus, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private View.OnClickListener btnListner=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getBaseContext(), ((Button)v).getText()+" was Clicked", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Toast.makeText(getBaseContext(), "Center was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Toast.makeText(getBaseContext(), "Left Arrow was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Toast.makeText(getBaseContext(), "Right Arrow was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                Toast.makeText(getBaseContext(), "Up Arrow was Clicked", Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Toast.makeText(getBaseContext(), "Down Arrow was Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
