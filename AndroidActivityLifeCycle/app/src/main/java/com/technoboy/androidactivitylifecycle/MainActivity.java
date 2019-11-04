package com.technoboy.androidactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //CSRPSRD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Life Cycle","onCreate Method Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Life Cycle","onStart Method Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Life Cycle","onResume Method Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Life Cycle","onPause Method Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Life Cycle","onStop Method Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Life Cycle","onRestart Method Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Life Cycle","onDestroy Method Called");
    }
}
