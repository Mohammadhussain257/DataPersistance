package com.mohammad.datapersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView=findViewById(R.id.list_item);
        dictionary=new HashMap<>();

        //Read from files
        readFromFile();

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet()));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key=parent.getItemAtPosition(position).toString();
                String meaning=dictionary.get(key);
                Intent intent=new Intent(ListActivity.this,DisplayActivity.class);
                intent.putExtra("meaning",meaning);
                startActivity(intent);
            }
        });

    }

    private  void readFromFile(){
        try {
            FileInputStream fis=openFileInput("words.txt");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                String [] parts=line.split("->");
                dictionary.put(parts[0],parts[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
