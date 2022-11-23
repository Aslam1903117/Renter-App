package com.example.renter_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
   private FloatingActionButton float_button;
    RecyclerView recview;
    ArrayList<model>datalist;
    FirebaseFirestore db;
    myadapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // floating action button start
        float_button=(FloatingActionButton) findViewById(R.id.btn_float);
        float_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(HomeActivity.this,Addpost.class);
                startActivity(intent);
            }
        });
        //floating action button
        recview=(RecyclerView) findViewById(R.id.recylerview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new myadapter(datalist);
        recview.setAdapter(adapter);

        db=FirebaseFirestore.getInstance();
        db.collection("posts").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot>list=queryDocumentSnapshots.getDocuments();
                         for(DocumentSnapshot d:list)
                         {
                            model obj=d.toObject(model.class);
                            datalist.add(obj);
                         }
                        adapter.notifyDataSetChanged();
                    }
                });

    }
}