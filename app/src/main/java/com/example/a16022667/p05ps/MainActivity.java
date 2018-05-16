package com.example.a16022667.p05ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSong, etYear, etSinger;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    Button btnInsert, btnDisplay;
    ArrayList<String> al;
    ArrayAdapter aa;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSinger = (EditText)findViewById(R.id.etSinger);
        etSong = (EditText)findViewById(R.id.etSong);
        etYear = (EditText)findViewById(R.id.etYear);
        btnDisplay = (Button)findViewById(R.id.buttonShowList);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        rb1 = (RadioButton)findViewById(R.id.radio1);
        rb2 = (RadioButton)findViewById(R.id.radio2);
        rb3 = (RadioButton)findViewById(R.id.radio3);
        rb4 = (RadioButton)findViewById(R.id.radio4);
        rb5 = (RadioButton)findViewById(R.id.radio5);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sing = etSinger.getText().toString();
                String song = etSong.getText().toString();
                String year = etYear.getText().toString();
                Integer star ;
                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSinger(sing);
                long song_affected = dbh.insertSong(song);
                long year_affected = dbh.insertYear(year);
                dbh.close();

                if (row_affected != 0){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        SecondActivity.class);
                String data = al.get(0);
                String id = data.split(",")[0].split(":")[1];
                String content = data.split(",")[1].trim();

                Note target = new Note(Integer.parseInt(id), content);

                i.putExtra("data", target);
                startActivity(i);

            }
        });

    }
}
