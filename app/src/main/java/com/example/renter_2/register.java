package com.example.renter_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.reg_email);
        password=findViewById(R.id.reg_password);
        register=findViewById(R.id.Register);
        auth =FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password))
                {
                    Toast.makeText(register.this,"Empty",Toast.LENGTH_SHORT).show();
                }
                else if(txt_password.length()<6)
                {
                    Toast.makeText(register.this,"Password must to bigger than 6",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    registerUser (txt_email,txt_password);
                    Intent intent=new Intent(register .this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            private void registerUser(String email, String password)
            {
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(register.this , new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(register.this, "Registered", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(register.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}