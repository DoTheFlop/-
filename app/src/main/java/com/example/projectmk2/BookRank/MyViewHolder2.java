package com.example.projectmk2.BookRank;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmk2.R;

public class MyViewHolder2 extends RecyclerView.ViewHolder {
    TextView tv1, tv2, tv3;
    public MyViewHolder2(View itemView){
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.item2Name);
        tv2 = (TextView) itemView.findViewById(R.id.item2Id);
        tv3 = (TextView) itemView.findViewById(R.id.rank);
    }
}
