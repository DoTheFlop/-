package com.example.projectmk2.BookSearch;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmk2.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv1, tv2, tv3, tv4, tv5;
    Button btn;
    public  MyViewHolder(View itemView){
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.item1Name);
        tv2 = (TextView) itemView.findViewById(R.id.item1Reservation);
        tv3 = (TextView) itemView.findViewById(R.id.item1Author);
        tv4 = (TextView) itemView.findViewById(R.id.item1Id);
        tv5 = (TextView) itemView.findViewById(R.id.item1Company);
        btn = (Button) itemView.findViewById(R.id.detailBtn);
    }

}
