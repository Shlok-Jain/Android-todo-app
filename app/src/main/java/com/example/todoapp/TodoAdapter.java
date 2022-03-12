package com.example.todoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<String> {
    private final ArrayList<String> arr;
    private final Context mContext;

    public TodoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> arr) {
        super(context, resource, arr);
        this.arr = arr;
        this.mContext = context;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.todo_layout,parent,false);
        TextView title =  convertView.findViewById(R.id.textView2);
        Button button = convertView.findViewById(R.id.btn);
        title.setText(getItem(position));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, getItem(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,ViewTodo.class);
                intent.putExtra("todo_title",getItem(position));
                mContext.startActivity(intent);
            }
        });
//        TextView desc = convertView.findViewById(R.id.textView4);
        return convertView;
    }
}
