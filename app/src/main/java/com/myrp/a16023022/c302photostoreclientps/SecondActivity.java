package com.myrp.a16023022.c302photostoreclientps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity  extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Category> cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvDeets);

        Intent i = getIntent();

        cat = new ArrayList<Category>();
        aa = new ArrayAdapter(this,R.layout.row, cat);

        lv.setAdapter(aa);



    }



}

