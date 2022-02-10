package com.example.projectmk2.BookMark;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmk2.R;
import com.example.projectmk2.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookMarkActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView3;
    private RecyclerView.Adapter mAdapter3;
    private RecyclerView.LayoutManager mLayoutManager3;
    ArrayList<bookInFo> myDataset3 = new ArrayList<bookInFo>();
    Button delAll;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        setTitle("즐겨찾기");
        mRecyclerView3 = (RecyclerView) findViewById(R.id.bookMarkRecyclerView);
        mLayoutManager3 = new LinearLayoutManager(this);
        mRecyclerView3.setLayoutManager(mLayoutManager3);
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        User.setUid(uid);
        mAdapter3 = new com.example.projectmk2.BookMark.MyAdapter3(myDataset3);
        mRecyclerView3.setAdapter(mAdapter3);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference(User.getUid());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myDataset3.clear();
                for(DataSnapshot ds : snapshot.child("bookInFo").getChildren()) {
                    //데이터를 담기위한 객체 모델
                    com.example.projectmk2.BookMark.bookInFo bookinfo = ds.getValue(com.example.projectmk2.BookMark.bookInFo.class);
                    //이 객체를 리스트에 넣는다.
                    myDataset3.add(bookinfo);
                    //이 리스트들을 어댑터에 넣어진다.
                }
                mAdapter3.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        delAll = (Button) findViewById(R.id.delAll);
        delAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.removeValue();
            }
        });
    }
}