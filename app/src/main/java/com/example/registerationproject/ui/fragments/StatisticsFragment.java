package com.example.registerationproject.ui.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.example.registerationproject.models.Course;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatisticsFragment extends Fragment {

    private TextView averageCompetitionRateTextView;
    private FirebaseFirestore db;
    private Button deleteButton;

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
        View view = inflater.inflate(R.layout.statistics, container, false);

        // Initialize views
        averageCompetitionRateTextView = view.findViewById(R.id.courseRate);
        deleteButton = view.findViewById(R.id.deleteButton);

        // Calculate and display the average competition rate for courses
        calculateAverageCompetitionRate();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform delete operation
                deleteCourse();
            }
        });

        return view;
    }

    private void calculateAverageCompetitionRate() {
        final int[] courseCount = {0};
        final int[] totalPersonnel = {0};
        final int[] totalLimit = {0};

        // Get saved courses from Firestore
        db.collection("schedules")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            Course course = document.toObject(Course.class);
                            if (course != null) {
                                courseCount[0]++;
                                totalPersonnel[0] += course.getPersonnel();
                                totalLimit[0] += course.getLimit();

                                // Set course information to TextViews
                                String courseName = course.getCourseName();
                                String courseDivide = course.getDivision();
                                String courseGrade = course.getGrade();
                                double courseRate = (double) course.getPersonnel() / course.getLimit();
                                int coursePersonnel = course.getPersonnel();
                                int courseLimit = course.getLimit();

                                // Find TextViews for course information
                                TextView courseNameTextView = getView().findViewById(R.id.courseName);
                                TextView courseDivideTextView = getView().findViewById(R.id.courseDivide);
                                TextView courseGradeTextView = getView().findViewById(R.id.courseGrade);
                                TextView courseRateTextView = getView().findViewById(R.id.courseRate);
                                TextView coursePersonnelTextView = getView().findViewById(R.id.coursePersonnel);
                                TextView courseLimitTextView = getView().findViewById(R.id.courseLimit);

                                // Set course information to TextViews
                                courseNameTextView.setText(courseName);
                                courseDivideTextView.setText(courseDivide);
                                courseGradeTextView.setText(courseGrade);
                                courseRateTextView.setText(String.format("%.2f", courseRate));
                                coursePersonnelTextView.setText(String.valueOf(coursePersonnel));
                                courseLimitTextView.setText(String.valueOf(courseLimit));
                            }
                        }

                        // Calculate average competition rate
                        double averageCompetitionRate = 0.0;
                        if (totalLimit[0] > 0) {
                            averageCompetitionRate = (double) totalPersonnel[0] / totalLimit[0];
                        }

                        // Display average competition rate
                        averageCompetitionRateTextView.setText(String.format("경쟁률: %.2f", averageCompetitionRate));
                    }
                });
    }


    private void deleteCourse() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        // Firestore에서 강의 목록을 가져와서 다이얼로그에 표시
        db.collection("schedules")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<String> courseNames = new ArrayList<>();
                        List<Course> courses = new ArrayList<>();

                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Course course = document.toObject(Course.class);
                            if (course != null) {
                                courses.add(course);
                                String courseName = course.getCourseName();
                                if (courseName != null) {
                                    courseNames.add(courseName);
                                }
                            }
                        }

                        CharSequence[] items = courseNames.toArray(new CharSequence[0]);

                        builder.setItems(items, (dialog, which) -> {
                            // 선택한 강의 삭제
                            String courseId = task.getResult().getDocuments().get(which).getId(); // 선택한 강의의 문서 ID
                            db.collection("schedules").document(courseId)
                                    .delete()
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(getContext(), "강의가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                                        // 삭제 후 필요한 작업 수행
                                        calculateAverageCompetitionRate(); // 삭제 후 경쟁률 다시 계산
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(getContext(), "강의 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                    });
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        Toast.makeText(getContext(), "강의 목록을 가져오는 데 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }



}


