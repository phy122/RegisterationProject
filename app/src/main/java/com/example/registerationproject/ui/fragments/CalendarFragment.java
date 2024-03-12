package com.example.registerationproject.ui.fragments;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.registerationproject.R;
import com.example.registerationproject.adapter.TodoAdapter;
import com.example.registerationproject.adapter.Utils;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment; //
    }

    private CalendarView calendarView;
    private EditText todoEditText;
    private Button addTodoButton;
    private ListView todoListView;
    private HashMap<String, ArrayList<String>> todoMap;

    private ArrayList<String> currentTodoList;
    private int selectedTodoPosition;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);

        calendarView = rootView.findViewById(R.id.calendarView);
        todoEditText = rootView.findViewById(R.id.todoEditText);
        addTodoButton = rootView.findViewById(R.id.addTodoButton);
        todoListView = rootView.findViewById(R.id.todoListView);
        todoMap = new HashMap<>();

        registerForContextMenu(todoListView);

        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDate = getSelectedDate();
                String todo = todoEditText.getText().toString().trim();

                if (!selectedDate.isEmpty() && !todo.isEmpty()) {
                    if (todoMap.containsKey(selectedDate)) {
                        todoMap.get(selectedDate).add(todo);
                    } else {
                        ArrayList<String> todoList = new ArrayList<>();
                        todoList.add(todo);
                        todoMap.put(selectedDate, todoList);
                    }

                    updateTodoListView(selectedDate);
                    todoEditText.setText("");
                }
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                updateTodoListView(selectedDate);
            }
        });

        return rootView;
    }

    private void updateTodoListView(String selectedDate) {
        if (todoMap.containsKey(selectedDate)) {
            currentTodoList = todoMap.get(selectedDate);
            TodoAdapter adapter = new TodoAdapter(requireContext(), R.layout.todo_item, currentTodoList);
            todoListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();  // 리스트뷰 갱신
        } else {
            currentTodoList = new ArrayList<>();
            todoListView.setAdapter(null);
        }
    }

    private String getSelectedDate() {
        long selectedDateMillis = calendarView.getDate();
        return Utils.getDateString(selectedDateMillis);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.todo_context_menu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        selectedTodoPosition = info.position;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editTodo:
                showEditDialog();
                return true;
            case R.id.deleteTodo:
                deleteTodo();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showEditDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Edit Todo");

        final EditText input = new EditText(requireContext());
        input.setText(currentTodoList.get(selectedTodoPosition));
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String editedTodo = input.getText().toString().trim();
                currentTodoList.set(selectedTodoPosition, editedTodo);
                updateTodoListView(getSelectedDate());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void deleteTodo() {
        currentTodoList.remove(selectedTodoPosition);
        updateTodoListView(getSelectedDate());
    }

}
