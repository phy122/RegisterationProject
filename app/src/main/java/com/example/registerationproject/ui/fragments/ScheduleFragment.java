package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.example.registerationproject.models.Course;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class ScheduleFragment extends Fragment {

    private TextView monday0930TextView;
    private TextView monday1045TextView;
    private TextView monday1100TextView;

    private FirebaseFirestore db;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        // Initialize views
        monday0930TextView = view.findViewById(R.id.monday0930courseInfoTextView);
        monday1045TextView = view.findViewById(R.id.monday1045courseInfoTextView);
        monday1100TextView = view.findViewById(R.id.monday1100courseInfoTextView);

        // Get saved courses from Firestore
        db.collection("schedules")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            Course course = document.toObject(Course.class);
                            displayCourse(course);
                        }
                    }
                });

        return view;
    }

    private void displayCourse(Course course) {
        // Display course information in corresponding TextViews
        if (course.getMondayStartTime().equals("09:30")) {
            monday0930TextView.setText(course.getCourseName());
            monday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
        }
        if (course.getMondayStartTime().equals("10:45")) {
            monday1045TextView.setText(course.getCourseName());
            monday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
        }
        if (course.getMondayStartTime().equals("11:00")) {
            monday1100TextView.setText(course.getCourseName());
            monday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
        }
        // 종료 시간에 대한 처리 추가
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("10:45")) {
            monday1045TextView.setText(course.getCourseName());
            monday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
        }
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("11:00")) {
            monday1100TextView.setText(course.getCourseName());
            monday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
        }
    }
}
