package com.example.a16022667.p05ps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	Note data;
	ListView lv;
	ArrayAdapter aa;
	ArrayList<String> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView
		Intent i = getIntent();
		data = (Note) i.getSerializableExtra("data");
		lv = (ListView)findViewById(R.id.lv);



	}


}
