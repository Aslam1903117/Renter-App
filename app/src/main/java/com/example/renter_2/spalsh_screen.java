package com.example.renter_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class spalsh_screen extends AppCompatActivity {
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(spalsh_screen.this,log_reg.class);
                startActivity(intent);
                finish();
            }
        },3000);    }
}