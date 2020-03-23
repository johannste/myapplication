package com.neusoft.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_list);
        List<String> list = new ArrayList<>();
        list.add("忒修斯之船");
        list.add("绝对零度");
        list.add("破解不在场证明少女");
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Log.d("parent", "onItemClick: " + parent);
            Log.d("view", "onItemClick: " + view);
            Log.d("position", "onItemClick: " + position);
            Log.d("id", "onItemClick: " + id);
        });
    }
}
