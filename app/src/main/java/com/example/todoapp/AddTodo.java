package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddTodo extends AppCompatActivity {
    EditText todo_title;
    EditText todo_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        todo_title = findViewById(R.id.todo_title);
        todo_desc = findViewById(R.id.todo_desc);
    }
    public void addtodo(View view){
        String title = todo_title.getText().toString();
        String desc = todo_desc.getText().toString();
        if(title.length()==0 || desc.length()==0){
            Toast.makeText(this, "Invalid title or description", Toast.LENGTH_SHORT).show();
        }
        else{
            SharedPreferences sp = getSharedPreferences("MyTodos",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            if(!sp.getString(title, "no value").equals("no value")){
                Toast.makeText(this, "Title already exists", Toast.LENGTH_SHORT).show();
            }
            else{
                ed.putString(title,desc);
                ed.apply();
                Toast.makeText(this, "Successfully added todo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }

}