package com.testleancould.dodo.lifecycledemo.step1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.testleancould.dodo.lifecycledemo.R;

public class ChronometerActivity1 extends AppCompatActivity {
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_chromometer);

          chronometer=findViewById(R.id.chonometer);

        Button refreshBtn=findViewById(R.id.refresh_button);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chronometer.setBase(SystemClock.elapsedRealtime());


            }
        });


        chronometer.start();
    }
}
