package com.example.registerationproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.registerationproject.R;

import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<String> {

    private Context context;
    private int resource;
    private ArrayList<String> todoList;

    public TodoAdapter(Context context, int resource, ArrayList<String> todoList) {
        super(context, resource, todoList);
        this.context = context;
        this.resource = resource;
        this.todoList = todoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);
        }

        String todo = todoList.get(position);

        if (todo != null) {
            TextView todoTextView = convertView.findViewById(R.id.todoTextView) ;
            todoTextView.setText(todo);
        }

        return convertView;
    }
}
