package com.example.projectmk2.BookMark;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmk2.R;

public class MyViewHolder3 extends RecyclerView.ViewHolder {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    Button btn, btnDel;
    public MyViewHolder3(View itemView){
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.item3Name);
        tv2 = (TextView) itemView.findViewById(R.id.item3Reservation);
        tv3 = (TextView) itemView.findViewById(R.id.item3Author);
        tv4 = (TextView) itemView.findViewById(R.id.item3Id);
        tv5 = (TextView) itemView.findViewById(R.id.item3Company);
        tv6 = (TextView) itemView.findViewById(R.id.item3BookMarkNum);
        btn = (Button) itemView.findViewById(R.id.detail3Btn);
        btnDel = (Button) itemView.findViewById(R.id.del3Btn);
    }
}
