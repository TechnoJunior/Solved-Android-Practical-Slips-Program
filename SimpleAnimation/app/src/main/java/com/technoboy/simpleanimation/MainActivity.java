package com.technoboy.simpleanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button expand,shrink,rotate,move;
    Animation animexpand,animshrink,animrotate,animmove;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expand=findViewById(R.id.btnExpand);
        shrink=findViewById(R.id.btnShrink);
        rotate=findViewById(R.id.btnRotate);
        move=findViewById(R.id.btnMove);
        imageView=findViewById(R.id.imageView);

        animexpand= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.expand);
        animshrink=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shrink);
        animrotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        animmove=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);

        expand.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.startAnimation(animexpand);
                    }
                }
        );
        shrink.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.startAnimation(animshrink);
                    }
                }
        );

        rotate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.startAnimation(animrotate);
                    }
                }
        );
        move.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.startAnimation(animmove);
                    }
                }
        );
    }
}
