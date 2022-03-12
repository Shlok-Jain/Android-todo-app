package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewTodo extends AppCompatActivity {
    TextView title;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo);
        title = findViewById(R.id.textView3);
        desc = findViewById(R.id.textView4);

        Intent intent = getIntent();
        String title_text = intent.getStringExtra("todo_title");
        title.setText(title_text);
        SharedPreferences sp = getSharedPreferences("MyTodos",MODE_PRIVATE);
        String desc_text = sp.getString(title_text,"No todo found");
        desc.setText(desc_text);
    }
    public void delete_todo(){
        String title_text = title.getText().toString();
        SharedPreferences sp = getSharedPreferences("MyTodos",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.remove(title_text);
        ed.apply();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Successfully Deleted Todo", Toast.LENGTH_SHORT).show();
    }
}