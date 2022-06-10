package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart,btnStop;
    TextView textCounter;
    int i=1;
    Handler customhandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=findViewById(R.id.button);
        btnStop=findViewById(R.id.button2);
        textCounter=findViewById(R.id.textView2);
        btnStart.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.postDelayed(updateTimerThread,0);
            }
        }));
        btnStop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.removeCallbacks(updateTimerThread);
            }
        }));
    }
    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            textCounter.setText(""+i);
            customhandler.postDelayed(this,1000);
            i++;
        }
    };
}