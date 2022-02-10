package com.example.projectmk2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectmk2.BookMark.BookMarkActivity;
import com.example.projectmk2.BookRank.BookRankActivity;
import com.example.projectmk2.BookSearch.BookSearchActivity;
import com.example.projectmk2.Login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainActivity extends AppCompatActivity {
    Button btnSearch, btnLogin, btnBookMark, btnBookRank;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("한밭대 도서관");

        btnBookMark = (Button) findViewById(R.id.btnBookMark);
        btnBookRank = (Button) findViewById(R.id.btnBookRank);
        btnSearch = (Button) findViewById(R.id.btnBookSerch);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        if(currentUser != null){
            btnLogin.setText(R.string.Logout);
        }

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookSearchActivity.class) ;
                startActivity(intent) ;
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentUser != null) {
                    FirebaseAuth.getInstance().signOut();
                    btnLogin.setText(R.string.Login);
                    currentUser = mAuth.getCurrentUser();
                    Toast.makeText(getApplicationContext(),"로그아웃 완료", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        btnBookRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookRankActivity.class) ;
                startActivity(intent) ;
            }
        });
        btnBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentUser == null){
                    Toast.makeText(getApplicationContext(), "로그인을 하세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, BookMarkActivity.class);
                    intent.putExtra("uid", currentUser.getUid());
                    startActivity(intent) ;
                }
            }
        });
    }
}