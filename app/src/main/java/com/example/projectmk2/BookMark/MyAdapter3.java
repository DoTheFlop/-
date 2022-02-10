package com.example.projectmk2.BookMark;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmk2.R;
import com.example.projectmk2.SecondActivity;
import com.example.projectmk2.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyViewHolder3> {
    private ArrayList<bookInFo> mDataset3;

    public MyAdapter3(ArrayList<bookInFo> myDataset3) {
        mDataset3 = myDataset3;
    }
    @Override
    public MyViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_bookmark, parent, false);
        MyViewHolder3 vh = new MyViewHolder3(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, int position) {
        holder.tv1.setText(mDataset3.get(position).bookName);
        holder.tv2.setText(mDataset3.get(position).Reservation);
        holder.tv3.setText(mDataset3.get(position).Author);
        holder.tv4.setText(mDataset3.get(position).bookId);
        holder.tv5.setText(mDataset3.get(position).Company);
        holder.tv6.setText(mDataset3.get(position).BookMarkNum);

        final Context mycontext = holder.itemView.getContext();

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mycontext, SecondActivity.class);
                int fromBookMarkCheck = 1;
                intent.putExtra("bookName", mDataset3.get(position).bookName);
                intent.putExtra("Author", mDataset3.get(position).Author);
                intent.putExtra("bookId", mDataset3.get(position).bookId);
                intent.putExtra("Reservation", mDataset3.get(position).Reservation);
                intent.putExtra("Company", mDataset3.get(position).Company);
                intent.putExtra("fromBookMarkCheck", fromBookMarkCheck);
                mycontext.startActivity(intent);
            }
        });
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference ref = FirebaseDatabase.getInstance().getReference(User.getUid());
                ref.child("bookInFo").child(mDataset3.get(position).BookMarkNum).removeValue();
            }
        });

    }
    public  int getItemCount(){
        return mDataset3.size();
    }
}
