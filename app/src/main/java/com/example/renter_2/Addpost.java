package com.example.renter_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class Addpost extends AppCompatActivity {

   Button addpost;
    TextView house_name,house_for,house_rent,owners_phone,house_location,house_description;


  FirebaseFirestore dbroot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost);

        house_name=findViewById(R.id.tv_house_name);
        house_for=findViewById(R.id.tv_house_for);
        house_rent=findViewById(R.id.tv_house_rent);
        owners_phone=findViewById(R.id.tv_owners_phone);
        house_description=findViewById(R.id.tv_house_description);
        house_location=findViewById(R.id.tv_house_location);
        addpost=findViewById(R.id.btn_give_post);

        dbroot=FirebaseFirestore.getInstance();

        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             insertData();

            }


        });


    }
  public void insertData()
  {
     Map<String,String>items=new HashMap<>();
     items.put("name",house_name.getText().toString().trim());
      items.put("fore",house_for.getText().toString().trim());
      items.put("rent",house_rent.getText().toString().trim());
      items.put("phone",owners_phone.getText().toString().trim());
      items.put("location",house_location.getText().toString().trim());
      items.put("description",house_description.getText().toString().trim());

      dbroot.collection("posts").add(items)
              .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                  @Override
                  public void onComplete(@NonNull Task<DocumentReference> task) {
                      house_name.setText("");
                      house_for.setText(" ");
                      house_rent.setText(" ");
                      owners_phone.setText(" ");
                      house_location.setText(" ");
                      house_description.setText(" ");
                      Toast.makeText(Addpost.this, "post added", Toast.LENGTH_SHORT).show();
                      Intent intent= new Intent(Addpost.this,HomeActivity.class);
                      startActivity(intent);
                  }
              });
   }

}