package com.mohammad.datapersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button btnAddWord,btnShowWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.btnAddWord=findViewById(R.id.btnAddWord);
        this.btnShowWords=findViewById(R.id.btnShowWords);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
               startActivity(intent);
            }
        });

        btnShowWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
