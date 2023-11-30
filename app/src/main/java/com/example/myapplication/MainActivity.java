package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> names, surnames, generated;
    int min, max;
    ListView lv;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.names)));
        surnames = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.surnames)));
        generated = new ArrayList<>();

        lv = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, R.layout.item);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void itemOnClick(View view) {

//        view.setBackgroundColor(getResources().getColor(R.color.teal_200));

        Log.d("mytag", String.valueOf(view.getTag()));
    }

    public void onClick(View view) {

        generated.add("");
        String new_element = "";

        while(generated.contains(new_element)){
            Random rnd = new Random();
            int indexName =  rnd.nextInt(names.size());
            int IndexSurname = rnd.nextInt(surnames.size());
            new_element = surnames.get(IndexSurname) + " " + names.get(indexName);
        }
        adapter.add(new_element);
        adapter.notifyDataSetChanged();
        generated.add(new_element);
    }
}
