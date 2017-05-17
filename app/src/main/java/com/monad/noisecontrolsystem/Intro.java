package com.monad.noisecontrolsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.monad.noisecontrolsystem.Activity.MainActivity;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
