package com.example.projectmk2.BookSearch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmk2.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class BookSearchActivity extends AppCompatActivity {

    private String htmlPageUrl;
    EditText searchBook;
    ArrayList<String> bookName = new ArrayList<String>();
    ArrayList<String> booking = new ArrayList<String>();
    ArrayList<String> bookAuthor = new ArrayList<String>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<PaintTitle> myDataset = new ArrayList<PaintTitle>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksearch);
        setTitle("도서 검색");

        searchBook = (EditText) findViewById(R.id.searchBook);
        mRecyclerView = (RecyclerView) findViewById(R.id.searchList);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        Button htmlTitleButton = (Button)findViewById(R.id.button);
        htmlTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    htmlPageUrl = "https://lib.hanbat.ac.kr/search/tot/result?st=KWRD&si=TOTAL&q="+ searchBook.getText() +"&oi=&os=&cpp=10";
                    myDataset.clear();
                    bookName.clear();
                    booking.clear();
                    bookAuthor.clear();
                    mAdapter.notifyDataSetChanged();
                    JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                    jsoupAsyncTask.execute();
                }catch (Exception e){
                    Log.w("BookSearch", "검색 실패");
                }

            }
        });
    }

    public class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements titles = doc.select(".searchTitle");
                Elements Reservation = doc.select(".book_state");
                Elements author = doc.select(".bookline");

                System.out.println("-------------------------------------------------------------");
                for(Element e: titles){
                    bookName.add(e.text());
                }
                for(Element e: Reservation){
                    booking.add(e.text());
                }
                for(Element e: author){
                    bookAuthor.add(e.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if(bookName.size() == 0){
                Toast.makeText(getApplicationContext(), "검색결과가 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(getApplicationContext(), "검색결과 완료", Toast.LENGTH_SHORT).show();
            for(int i = 0; i < bookName.size(); i++){
                if(booking.get(i) != "대출가능" || booking.get(i) != "대출중"){
                    booking.add("");
                }
                myDataset.add(new PaintTitle(bookName.get(i), booking.get(i), bookAuthor.get(i*6), bookAuthor.get(i*6+2), bookAuthor.get(i*6+1)));
            }
            mAdapter.notifyDataSetChanged();
        }
    }
}

