package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.example.registerationproject.adapter.StatisticsAdapter;
import com.example.registerationproject.models.Course;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends Fragment {

    private ListView courseListView;
    private StatisticsAdapter courseAdapter;
    private FirebaseFirestore db;

    public StatisticsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        // Initialize views
        courseListView = view.findViewById(R.id.courseListView);

        // Initialize adapter
        List<Course> courses = new ArrayList<>();
        courseAdapter = new StatisticsAdapter(getContext(), courses);
        courseListView.setAdapter(courseAdapter);

        // Load courses from Firestore
        loadCourses();

        return view;
    }

    private void loadCourses() {
        // Firestore에서 강의 데이터를 가져옵니다.
        db.collection("schedules")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Course> courses = new ArrayList<>();

                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Course course = document.toObject(Course.class);
                            if (course != null) {
                                course.setDocumentId(document.getId()); // 문서 ID를 Course 객체에 설정
                                courses.add(course);
                            }
                        }

                        // 어댑터에 데이터를 설정하고 어댑터를 갱신합니다.
                        courseAdapter.updateCourses(courses);
                        courseAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getContext(), "강의 목록을 가져오는 데 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
