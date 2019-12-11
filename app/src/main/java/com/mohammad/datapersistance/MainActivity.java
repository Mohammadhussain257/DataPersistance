package com.mohammad.datapersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    EditText etWord,etMeaning;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord=findViewById(R.id.etWord);
        etMeaning=findViewById(R.id.etMeaning);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });

    }

    private void Save(){
        try{
            PrintStream printStream=new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etWord.getText()+"->"+etMeaning.getText().toString());
            Toast.makeText(this,"Save To"+getFilesDir(),Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Log.d("Dictionary app","Error"+e.toString());
            e.printStackTrace();
        }
    }
}
