package com.example.projectmk2.BookRank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projectmk2.R;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {
    private ArrayList<PaintTitle2> mDataset2;
    public MyAdapter2(ArrayList<PaintTitle2> myDataset2) {
        mDataset2 = myDataset2;
    }
    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_bookrank, parent, false);
        MyViewHolder2 vh = new MyViewHolder2(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.tv1.setText(mDataset2.get(position).title);
        holder.tv2.setText(mDataset2.get(position).reservation);
        holder.tv3.setText(mDataset2.get(position).rank+"위");
    }
    public  int getItemCount(){
        return mDataset2.size();
    }
}
