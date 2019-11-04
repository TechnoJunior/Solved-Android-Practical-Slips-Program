package com.technoboy.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText);
        add=findViewById(R.id.button);

        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
                        String nm=name.getText().toString();
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name",nm);
                        editor.commit();
                        Toast.makeText(MainActivity.this, "Name added in Shared Preferences", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
