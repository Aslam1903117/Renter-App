package com.example.renter_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.renter_2.R;

public class log_reg extends AppCompatActivity {
    private Button login;
    private Button register;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);
        login= findViewById(R.id.sign_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(log_reg.this, com.example.renter_2.login.class);
                startActivity(intent);
                finish();
            }
        });
        register= findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(log_reg.this,register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}