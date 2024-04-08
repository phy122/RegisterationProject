package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.example.registerationproject.models.Course;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class ScheduleFragment extends Fragment {

    private TextView monday0930TextView;
    private TextView monday1045TextView;
    private TextView monday1100TextView;
    private TextView tuesday1600TextView;
    private TextView tuesday1715TextView;
    private TextView wednesday1100TextView;
    private TextView wednesday1215TextView;

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
        tuesday1600TextView = view.findViewById(R.id.tuesday1600courseInfoTextView);
        tuesday1715TextView = view.findViewById(R.id.tuesday1845courseInfoTextView);
        wednesday1100TextView = view.findViewById(R.id.wednesday1100courseInfoTextView);
        wednesday1215TextView = view.findViewById(R.id.wednesday1215courseInfoTextView);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Course course = (Course) bundle.getSerializable("course");
            if (course != null) {
                displayCourse(course);
                saveCourseToFirestore(course);
            } else {
                showToast("강의 정보를 불러오지 못했습니다.");
            }
        }
        loadCoursesFromFirestore();

        return view;
    }

    private void displayCourse(Course course) {
        // Display course information in corresponding TextViews
        if (course.getMondayStartTime().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday0930TextView.setText("");
                monday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday0930TextView.setTextSize(10);
                monday0930TextView.setText(course.getCourseName());
                monday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1045TextView.setText("");
                monday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1045TextView.setTextSize(10);
                monday1045TextView.setText(course.getCourseName());
                monday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1100TextView.setText("");
                monday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1100TextView.setText(course.getCourseName());
                monday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1045TextView.setText("");
                monday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1045TextView.setTextSize(10);
                monday1045TextView.setText(course.getCourseName());
                monday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1100TextView.setText("");
                monday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday0930TextView.setTextSize(10);
                monday1100TextView.setText(course.getCourseName());
                monday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        if (course.getWednesdayStartTime2() != null && course.getWednesdayStartTime2().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1100TextView.setText("");
                wednesday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1100TextView.setTextSize(10);
                wednesday1100TextView.setText(course.getCourseName());
                wednesday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        // Wednesday 12:15 시작 강의 처리
        if (course.getWednesdayStartTime2() != null && course.getWednesdayStartTime2().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1215TextView.setText("");
                wednesday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1215TextView.setTextSize(10);
                wednesday1215TextView.setText(course.getCourseName());
                wednesday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        // 종료 시간에 대한 처리 추가
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1215TextView.setText("");
                wednesday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1215TextView.setTextSize(10);
                wednesday1215TextView.setText(course.getCourseName());
                wednesday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        // 종료 시간에 대한 처리 추가
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1100TextView.setText("");
                wednesday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1100TextView.setTextSize(10);
                wednesday1100TextView.setText(course.getCourseName());
                wednesday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
    }

    private void saveCourseToFirestore(Course course) {
        // Firestore에 추가할 시간표 데이터 설정
        String documentId = course.getDayAndTimeRange();
        String documentId2 = course.getDayAndTimeRange2();
        // Firestore에 시간표 추가
        db.collection("schedules").document()
                .set(course)
                .addOnSuccessListener(aVoid -> showToast("시간표가 추가되었습니다."))
                .addOnFailureListener(e -> showToast("시간표 추가에 실패했습니다."));
    }

    private void loadCoursesFromFirestore() {
        // Retrieve courses from Firestore
        db.collection("schedules")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            Course course = document.toObject(Course.class);
                            displayCourse(course); // Display each course on UI
                        }
                    } else {
                        showToast("Failed to load courses from Firestore.");
                    }
                });
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}
