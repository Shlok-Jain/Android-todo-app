package com.example.todoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todoapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    private ActivityMainBinding binding;
    private ArrayList<String> arr = new ArrayList<String>(); //I am using an array list which i am initialising here this wil be used to store the list of title got from sharedprefs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        listview = findViewById(R.id.listview);

        SharedPreferences sp = getSharedPreferences("MyTodos",MODE_PRIVATE);
        Map<String, ?> allEntries = sp.getAll(); //Map acts as a loop for all entries in the sharedpref
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            this.arr.add(entry.getKey()); // this will add title in arr arraylist
        }
        TodoAdapter ad = new TodoAdapter(this,R.layout.todo_layout,arr);
        listview.setAdapter(ad);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addtodo = new Intent(getApplicationContext(),AddTodo.class);
                startActivity(addtodo);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_creator){
            Toast.makeText(this, "this app is created by Shlok Jain", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}