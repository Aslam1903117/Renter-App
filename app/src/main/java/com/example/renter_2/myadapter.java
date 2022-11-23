package com.example.renter_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    ArrayList<model>datalist;

    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
      return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.house_name.setText(datalist.get(position).getName());
        holder.house_for.setText(datalist.get(position).getFore());
        holder.house_rent.setText(datalist.get(position).getRent());
        holder.owners_phone.setText(datalist.get(position).getPhone());
        holder.house_location.setText(datalist.get(position).getLocation());
        holder.house_description.setText(datalist.get(position).getDescription());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {

        return datalist.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView house_name,house_for,house_rent,owners_phone,house_location,house_description;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            house_name=itemView.findViewById(R.id.house_name);
            house_for=itemView.findViewById(R.id.house_for);
            house_rent=itemView.findViewById(R.id.house_rent);
            owners_phone=itemView.findViewById(R.id.owners_phone);
            house_location=itemView.findViewById(R.id.house_location);
            house_description=itemView.findViewById(R.id.house_description);



        }
    }
}
