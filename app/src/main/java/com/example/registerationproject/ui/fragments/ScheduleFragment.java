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
    private TextView monday1215TextView;
    private TextView monday1300TextView;
    private TextView monday1415TextView;
    private TextView monday1430TextView;
    private TextView monday1545TextView;
    private TextView monday1600TextView;
    private TextView monday1715TextView;
    private TextView monday1730TextView;
    private TextView monday1845TextView;
    private TextView tuesday0930TextView;
    private TextView tuesday1045TextView;
    private TextView tuesday1100TextView;
    private TextView tuesday1215TextView;
    private TextView tuesday1300TextView;
    private TextView tuesday1415TextView;
    private TextView tuesday1430TextView;
    private TextView tuesday1545TextView;
    private TextView tuesday1600TextView;
    private TextView tuesday1715TextView;
    private TextView tuesday1730TextView;
    private TextView tuesday1845TextView;
    private TextView wednesday0930TextView;
    private TextView wednesday1045TextView;
    private TextView wednesday1100TextView;
    private TextView wednesday1215TextView;
    private TextView wednesday1300TextView;
    private TextView wednesday1415TextView;
    private TextView wednesday1430TextView;
    private TextView wednesday1545TextView;
    private TextView wednesday1600TextView;
    private TextView wednesday1715TextView;
    private TextView wednesday1730TextView;
    private TextView wednesday1845TextView;
    private TextView thursday0930TextView;
    private TextView thursday1045TextView;
    private TextView thursday1100TextView;
    private TextView thursday1215TextView;
    private TextView thursday1300TextView;
    private TextView thursday1415TextView;
    private TextView thursday1430TextView;
    private TextView thursday1545TextView;
    private TextView thursday1600TextView;
    private TextView thursday1715TextView;
    private TextView thursday1730TextView;
    private TextView thursday1845TextView;
    private TextView friday0930TextView;
    private TextView friday1045TextView;
    private TextView friday1100TextView;
    private TextView friday1215TextView;
    private TextView friday1300TextView;
    private TextView friday1415TextView;
    private TextView friday1430TextView;
    private TextView friday1545TextView;
    private TextView friday1600TextView;
    private TextView friday1715TextView;
    private TextView friday1730TextView;
    private TextView friday1845TextView;

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
        monday1215TextView = view.findViewById(R.id.monday1215courseInfoTextView);
        monday1300TextView = view.findViewById(R.id.monday1300courseInfoTextView);
        monday1415TextView = view.findViewById(R.id.monday1415courseInfoTextView);
        monday1430TextView = view.findViewById(R.id.monday1430courseInfoTextView);
        monday1545TextView = view.findViewById(R.id.monday1545courseInfoTextView);
        monday1600TextView = view.findViewById(R.id.monday1600courseInfoTextView);
        monday1715TextView = view.findViewById(R.id.monday1715courseInfoTextView);
        monday1730TextView = view.findViewById(R.id.monday1730courseInfoTextView);
        monday1845TextView = view.findViewById(R.id.monday1845courseInfoTextView);
        tuesday0930TextView = view.findViewById(R.id.tuesday0930courseInfoTextView);
        tuesday1045TextView = view.findViewById(R.id.tuesday1045courseInfoTextView);
        tuesday1100TextView = view.findViewById(R.id.tuesday1100courseInfoTextView);
        tuesday1215TextView = view.findViewById(R.id.tuesday1215courseInfoTextView);
        tuesday1300TextView = view.findViewById(R.id.tuesday1300courseInfoTextView);
        tuesday1415TextView = view.findViewById(R.id.tuesday1415courseInfoTextView);
        tuesday1430TextView = view.findViewById(R.id.tuesday1430courseInfoTextView);
        tuesday1545TextView = view.findViewById(R.id.tuesday1545courseInfoTextView);
        tuesday1600TextView = view.findViewById(R.id.tuesday1600courseInfoTextView);
        tuesday1715TextView = view.findViewById(R.id.tuesday1715courseInfoTextView);
        tuesday1730TextView = view.findViewById(R.id.tuesday1730courseInfoTextView);
        tuesday1845TextView = view.findViewById(R.id.tuesday1845courseInfoTextView);
        wednesday0930TextView = view.findViewById(R.id.wednesday0930courseInfoTextView);
        wednesday1045TextView = view.findViewById(R.id.wednesday1045courseInfoTextView);
        wednesday1100TextView = view.findViewById(R.id.wednesday1100courseInfoTextView);
        wednesday1215TextView = view.findViewById(R.id.wednesday1215courseInfoTextView);
        wednesday1300TextView = view.findViewById(R.id.wednesday1300courseInfoTextView);
        wednesday1415TextView = view.findViewById(R.id.wednesday1415courseInfoTextView);
        wednesday1430TextView = view.findViewById(R.id.wednesday1430courseInfoTextView);
        wednesday1545TextView = view.findViewById(R.id.wednesday1545courseInfoTextView);
        wednesday1600TextView = view.findViewById(R.id.wednesday1600courseInfoTextView);
        wednesday1715TextView = view.findViewById(R.id.wednesday1715courseInfoTextView);
        wednesday1730TextView = view.findViewById(R.id.wednesday1730courseInfoTextView);
        wednesday1845TextView = view.findViewById(R.id.wednesday1845courseInfoTextView);
        thursday0930TextView = view.findViewById(R.id.thursday0930courseInfoTextView);
        thursday1045TextView = view.findViewById(R.id.thursday1045courseInfoTextView);
        thursday1100TextView = view.findViewById(R.id.thursday1100courseInfoTextView);
        thursday1215TextView = view.findViewById(R.id.thursday1215courseInfoTextView);
        thursday1300TextView = view.findViewById(R.id.thursday1300courseInfoTextView);
        thursday1415TextView = view.findViewById(R.id.thursday1415courseInfoTextView);
        thursday1430TextView = view.findViewById(R.id.thursday1430courseInfoTextView);
        thursday1545TextView = view.findViewById(R.id.thursday1545courseInfoTextView);
        thursday1600TextView = view.findViewById(R.id.thursday1600courseInfoTextView);
        thursday1715TextView = view.findViewById(R.id.thursday1715courseInfoTextView);
        thursday1730TextView = view.findViewById(R.id.thursday1730courseInfoTextView);
        thursday1845TextView = view.findViewById(R.id.thursday1845courseInfoTextView);
        friday0930TextView = view.findViewById(R.id.friday0930courseInfoTextView);
        friday1045TextView = view.findViewById(R.id.friday1045courseInfoTextView);
        friday1100TextView = view.findViewById(R.id.friday1100courseInfoTextView);
        friday1215TextView = view.findViewById(R.id.friday1215courseInfoTextView);
        friday1300TextView = view.findViewById(R.id.friday1300courseInfoTextView);
        friday1415TextView = view.findViewById(R.id.friday1415courseInfoTextView);
        friday1430TextView = view.findViewById(R.id.friday1430courseInfoTextView);
        friday1545TextView = view.findViewById(R.id.friday1545courseInfoTextView);
        friday1600TextView = view.findViewById(R.id.friday1600courseInfoTextView);
        friday1715TextView = view.findViewById(R.id.friday1715courseInfoTextView);
        friday1730TextView = view.findViewById(R.id.friday1730courseInfoTextView);
        friday1845TextView = view.findViewById(R.id.friday1845courseInfoTextView);

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
        if (course.getMondayStartTime().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1100TextView.setText("");
                monday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1100TextView.setTextSize(10);
                monday1100TextView.setText(course.getCourseName());
                monday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1300TextView.setText("");
                monday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1300TextView.setTextSize(10);
                monday1300TextView.setText(course.getCourseName());
                monday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1430TextView.setText("");
                monday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1430TextView.setTextSize(10);
                monday1430TextView.setText(course.getCourseName());
                monday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1600TextView.setText("");
                monday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1600TextView.setTextSize(10);
                monday1600TextView.setText(course.getCourseName());
                monday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1730TextView.setText("");
                monday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1730TextView.setTextSize(10);
                monday1730TextView.setText(course.getCourseName());
                monday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
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
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1215TextView.setText("");
                monday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1215TextView.setTextSize(10);
                monday1215TextView.setText(course.getCourseName());
                monday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1415TextView.setText("");
                monday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1415TextView.setTextSize(10);
                monday1415TextView.setText(course.getCourseName());
                monday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1545TextView.setText("");
                monday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1545TextView.setTextSize(10);
                monday1545TextView.setText(course.getCourseName());
                monday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1715TextView.setText("");
                monday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1715TextView.setTextSize(10);
                monday1715TextView.setText(course.getCourseName());
                monday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime() != null && course.getMondayEndTime().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1845TextView.setText("");
                monday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1845TextView.setTextSize(10);
                monday1845TextView.setText(course.getCourseName());
                monday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }


        if (course.getTuesdayStartTime().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday0930TextView.setText("");
                tuesday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday0930TextView.setTextSize(10);
                tuesday0930TextView.setText(course.getCourseName());
                tuesday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1100TextView.setText("");
                tuesday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1100TextView.setTextSize(10);
                tuesday1100TextView.setText(course.getCourseName());
                tuesday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1300TextView.setText("");
                tuesday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1300TextView.setTextSize(10);
                tuesday1300TextView.setText(course.getCourseName());
                tuesday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1430TextView.setText("");
                tuesday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1430TextView.setTextSize(10);
                tuesday1430TextView.setText(course.getCourseName());
                tuesday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1600TextView.setText("");
                tuesday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1600TextView.setTextSize(10);
                tuesday1600TextView.setText(course.getCourseName());
                tuesday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1730TextView.setText("");
                tuesday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1730TextView.setTextSize(10);
                tuesday1730TextView.setText(course.getCourseName());
                tuesday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getTuesdayEndTime() != null && course.getTuesdayEndTime().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1045TextView.setText("");
                tuesday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1045TextView.setTextSize(10);
                tuesday1045TextView.setText(course.getCourseName());
                tuesday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime() != null && course.getTuesdayEndTime().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1215TextView.setText("");
                tuesday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1215TextView.setTextSize(10);
                tuesday1215TextView.setText(course.getCourseName());
                tuesday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime() != null && course.getTuesdayEndTime().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1415TextView.setText("");
                tuesday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1415TextView.setTextSize(10);
                tuesday1415TextView.setText(course.getCourseName());
                tuesday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime() != null && course.getTuesdayEndTime().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1545TextView.setText("");
                tuesday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1545TextView.setTextSize(10);
                tuesday1545TextView.setText(course.getCourseName());
                tuesday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime() != null && course.getTuesdayEndTime().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1715TextView.setText("");
                tuesday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1715TextView.setTextSize(10);
                tuesday1715TextView.setText(course.getCourseName());
                tuesday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime() != null && course.getTuesdayEndTime().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1845TextView.setText("");
                tuesday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1845TextView.setTextSize(10);
                tuesday1845TextView.setText(course.getCourseName());
                tuesday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }


        if (course.getWednesdayStartTime().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday0930TextView.setText("");
                wednesday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday0930TextView.setTextSize(10);
                wednesday0930TextView.setText(course.getCourseName());
                wednesday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime().equals("11:00")) {
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
        if (course.getWednesdayStartTime().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1300TextView.setText("");
                wednesday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1300TextView.setTextSize(10);
                wednesday1300TextView.setText(course.getCourseName());
                wednesday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1430TextView.setText("");
                wednesday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1430TextView.setTextSize(10);
                wednesday1430TextView.setText(course.getCourseName());
                wednesday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1600TextView.setText("");
                wednesday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1600TextView.setTextSize(10);
                wednesday1600TextView.setText(course.getCourseName());
                wednesday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1730TextView.setText("");
                wednesday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1730TextView.setTextSize(10);
                wednesday1730TextView.setText(course.getCourseName());
                wednesday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getWednesdayEndTime() != null && course.getWednesdayEndTime().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1045TextView.setText("");
                wednesday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1045TextView.setTextSize(10);
                wednesday1045TextView.setText(course.getCourseName());
                wednesday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime() != null && course.getWednesdayEndTime().equals("12:15")) {
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
        if (course.getWednesdayEndTime() != null && course.getWednesdayEndTime().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1415TextView.setText("");
                wednesday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1415TextView.setTextSize(10);
                wednesday1415TextView.setText(course.getCourseName());
                wednesday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime() != null && course.getWednesdayEndTime().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1545TextView.setText("");
                wednesday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1545TextView.setTextSize(10);
                wednesday1545TextView.setText(course.getCourseName());
                wednesday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime() != null && course.getWednesdayEndTime().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1715TextView.setText("");
                wednesday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1715TextView.setTextSize(10);
                wednesday1715TextView.setText(course.getCourseName());
                wednesday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime() != null && course.getWednesdayEndTime().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1845TextView.setText("");
                wednesday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1845TextView.setTextSize(10);
                wednesday1845TextView.setText(course.getCourseName());
                wednesday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }


        if (course.getThursdayStartTime().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday0930TextView.setText("");
                thursday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday0930TextView.setTextSize(10);
                thursday0930TextView.setText(course.getCourseName());
                thursday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1100TextView.setText("");
                thursday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1100TextView.setTextSize(10);
                thursday1100TextView.setText(course.getCourseName());
                thursday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1300TextView.setText("");
                thursday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1300TextView.setTextSize(10);
                thursday1300TextView.setText(course.getCourseName());
                thursday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1430TextView.setText("");
                thursday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1430TextView.setTextSize(10);
                thursday1430TextView.setText(course.getCourseName());
                thursday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1600TextView.setText("");
                thursday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1600TextView.setTextSize(10);
                thursday1600TextView.setText(course.getCourseName());
                thursday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1730TextView.setText("");
                thursday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1730TextView.setTextSize(10);
                thursday1730TextView.setText(course.getCourseName());
                thursday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getThursdayEndTime() != null && course.getThursdayEndTime().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1045TextView.setText("");
                thursday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1045TextView.setTextSize(10);
                thursday1045TextView.setText(course.getCourseName());
                thursday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime() != null && course.getThursdayEndTime().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1215TextView.setText("");
                thursday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1215TextView.setTextSize(10);
                thursday1215TextView.setText(course.getCourseName());
                thursday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime() != null && course.getThursdayEndTime().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1415TextView.setText("");
                thursday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1415TextView.setTextSize(10);
                thursday1415TextView.setText(course.getCourseName());
                thursday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime() != null && course.getThursdayEndTime().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1545TextView.setText("");
                thursday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1545TextView.setTextSize(10);
                thursday1545TextView.setText(course.getCourseName());
                thursday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime() != null && course.getThursdayEndTime().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1715TextView.setText("");
                thursday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1715TextView.setTextSize(10);
                thursday1715TextView.setText(course.getCourseName());
                thursday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime() != null && course.getThursdayEndTime().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1845TextView.setText("");
                thursday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1845TextView.setTextSize(10);
                thursday1845TextView.setText(course.getCourseName());
                thursday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }


        if (course.getFridayStartTime().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday0930TextView.setText("");
                friday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday0930TextView.setTextSize(10);
                friday0930TextView.setText(course.getCourseName());
                friday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1100TextView.setText("");
                friday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1100TextView.setTextSize(10);
                friday1100TextView.setText(course.getCourseName());
                friday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1300TextView.setText("");
                friday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1300TextView.setTextSize(10);
                friday1300TextView.setText(course.getCourseName());
                friday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1430TextView.setText("");
                friday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1430TextView.setTextSize(10);
                friday1430TextView.setText(course.getCourseName());
                friday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1600TextView.setText("");
                friday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1600TextView.setTextSize(10);
                friday1600TextView.setText(course.getCourseName());
                friday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1730TextView.setText("");
                friday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1730TextView.setTextSize(10);
                friday1730TextView.setText(course.getCourseName());
                friday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getFridayEndTime() != null && course.getFridayEndTime().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1045TextView.setText("");
                friday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1045TextView.setTextSize(10);
                friday1045TextView.setText(course.getCourseName());
                friday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime() != null && course.getFridayEndTime().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1215TextView.setText("");
                friday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1215TextView.setTextSize(10);
                friday1215TextView.setText(course.getCourseName());
                friday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime() != null && course.getFridayEndTime().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1415TextView.setText("");
                friday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1415TextView.setTextSize(10);
                friday1415TextView.setText(course.getCourseName());
                friday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime() != null && course.getFridayEndTime().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1545TextView.setText("");
                friday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1545TextView.setTextSize(10);
                friday1545TextView.setText(course.getCourseName());
                friday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime() != null && course.getFridayEndTime().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1715TextView.setText("");
                friday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1715TextView.setTextSize(10);
                friday1715TextView.setText(course.getCourseName());
                friday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime() != null && course.getFridayEndTime().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1845TextView.setText("");
                friday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1845TextView.setTextSize(10);
                friday1845TextView.setText(course.getCourseName());
                friday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        if (course.getMondayStartTime2().equals("09:30")) {
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
        if (course.getMondayStartTime2().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1100TextView.setText("");
                monday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1100TextView.setTextSize(10);
                monday1100TextView.setText(course.getCourseName());
                monday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime2().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1300TextView.setText("");
                monday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1300TextView.setTextSize(10);
                monday1300TextView.setText(course.getCourseName());
                monday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime2().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1430TextView.setText("");
                monday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1430TextView.setTextSize(10);
                monday1430TextView.setText(course.getCourseName());
                monday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime2().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1600TextView.setText("");
                monday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1600TextView.setTextSize(10);
                monday1600TextView.setText(course.getCourseName());
                monday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayStartTime2().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1730TextView.setText("");
                monday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1730TextView.setTextSize(10);
                monday1730TextView.setText(course.getCourseName());
                monday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getMondayEndTime2() != null && course.getMondayEndTime2().equals("10:45")) {
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
        if (course.getMondayEndTime2() != null && course.getMondayEndTime2().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1215TextView.setText("");
                monday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1215TextView.setTextSize(10);
                monday1215TextView.setText(course.getCourseName());
                monday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime2() != null && course.getMondayEndTime2().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1415TextView.setText("");
                monday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1415TextView.setTextSize(10);
                monday1415TextView.setText(course.getCourseName());
                monday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime2() != null && course.getMondayEndTime2().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1545TextView.setText("");
                monday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1545TextView.setTextSize(10);
                monday1545TextView.setText(course.getCourseName());
                monday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime2() != null && course.getMondayEndTime2().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1715TextView.setText("");
                monday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1715TextView.setTextSize(10);
                monday1715TextView.setText(course.getCourseName());
                monday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getMondayEndTime2() != null && course.getMondayEndTime2().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                monday1845TextView.setText("");
                monday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                monday1845TextView.setTextSize(10);
                monday1845TextView.setText(course.getCourseName());
                monday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        if (course.getTuesdayStartTime2().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday0930TextView.setText("");
                tuesday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday0930TextView.setTextSize(10);
                tuesday0930TextView.setText(course.getCourseName());
                tuesday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime2().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1100TextView.setText("");
                tuesday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1100TextView.setTextSize(10);
                tuesday1100TextView.setText(course.getCourseName());
                tuesday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime2().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1300TextView.setText("");
                tuesday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1300TextView.setTextSize(10);
                tuesday1300TextView.setText(course.getCourseName());
                tuesday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime2().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1430TextView.setText("");
                tuesday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1430TextView.setTextSize(10);
                tuesday1430TextView.setText(course.getCourseName());
                tuesday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime2().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1600TextView.setText("");
                tuesday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1600TextView.setTextSize(10);
                tuesday1600TextView.setText(course.getCourseName());
                tuesday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayStartTime2().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1730TextView.setText("");
                tuesday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1730TextView.setTextSize(10);
                tuesday1730TextView.setText(course.getCourseName());
                tuesday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getTuesdayEndTime2() != null && course.getTuesdayEndTime2().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1045TextView.setText("");
                tuesday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1045TextView.setTextSize(10);
                tuesday1045TextView.setText(course.getCourseName());
                tuesday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime2() != null && course.getTuesdayEndTime2().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1215TextView.setText("");
                tuesday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1215TextView.setTextSize(10);
                tuesday1215TextView.setText(course.getCourseName());
                tuesday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime2() != null && course.getTuesdayEndTime2().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1415TextView.setText("");
                tuesday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1415TextView.setTextSize(10);
                tuesday1415TextView.setText(course.getCourseName());
                tuesday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime2() != null && course.getTuesdayEndTime2().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1545TextView.setText("");
                tuesday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1545TextView.setTextSize(10);
                tuesday1545TextView.setText(course.getCourseName());
                tuesday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime2() != null && course.getTuesdayEndTime2().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1715TextView.setText("");
                tuesday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1715TextView.setTextSize(10);
                tuesday1715TextView.setText(course.getCourseName());
                tuesday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getTuesdayEndTime2() != null && course.getTuesdayEndTime2().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                tuesday1845TextView.setText("");
                tuesday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                tuesday1845TextView.setTextSize(10);
                tuesday1845TextView.setText(course.getCourseName());
                tuesday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        if (course.getWednesdayStartTime2().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday0930TextView.setText("");
                wednesday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday0930TextView.setTextSize(10);
                wednesday0930TextView.setText(course.getCourseName());
                wednesday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime2().equals("11:00")) {
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
        if (course.getWednesdayStartTime2().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1300TextView.setText("");
                wednesday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1300TextView.setTextSize(10);
                wednesday1300TextView.setText(course.getCourseName());
                wednesday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime2().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1430TextView.setText("");
                wednesday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1430TextView.setTextSize(10);
                wednesday1430TextView.setText(course.getCourseName());
                wednesday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime2().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1600TextView.setText("");
                wednesday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1600TextView.setTextSize(10);
                wednesday1600TextView.setText(course.getCourseName());
                wednesday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayStartTime2().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1730TextView.setText("");
                wednesday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1730TextView.setTextSize(10);
                wednesday1730TextView.setText(course.getCourseName());
                wednesday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1045TextView.setText("");
                wednesday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1045TextView.setTextSize(10);
                wednesday1045TextView.setText(course.getCourseName());
                wednesday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
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
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1415TextView.setText("");
                wednesday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1415TextView.setTextSize(10);
                wednesday1415TextView.setText(course.getCourseName());
                wednesday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1545TextView.setText("");
                wednesday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1545TextView.setTextSize(10);
                wednesday1545TextView.setText(course.getCourseName());
                wednesday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1715TextView.setText("");
                wednesday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1715TextView.setTextSize(10);
                wednesday1715TextView.setText(course.getCourseName());
                wednesday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getWednesdayEndTime2() != null && course.getWednesdayEndTime2().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                wednesday1845TextView.setText("");
                wednesday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                wednesday1845TextView.setTextSize(10);
                wednesday1845TextView.setText(course.getCourseName());
                wednesday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        if (course.getThursdayStartTime2().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday0930TextView.setText("");
                thursday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday0930TextView.setTextSize(10);
                thursday0930TextView.setText(course.getCourseName());
                thursday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime2().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1100TextView.setText("");
                thursday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1100TextView.setTextSize(10);
                thursday1100TextView.setText(course.getCourseName());
                thursday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime2().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1300TextView.setText("");
                thursday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1300TextView.setTextSize(10);
                thursday1300TextView.setText(course.getCourseName());
                thursday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime2().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1430TextView.setText("");
                thursday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1430TextView.setTextSize(10);
                thursday1430TextView.setText(course.getCourseName());
                thursday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime2().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1600TextView.setText("");
                thursday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1600TextView.setTextSize(10);
                thursday1600TextView.setText(course.getCourseName());
                thursday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayStartTime2().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1730TextView.setText("");
                thursday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1730TextView.setTextSize(10);
                thursday1730TextView.setText(course.getCourseName());
                thursday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getThursdayEndTime2() != null && course.getThursdayEndTime2().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1045TextView.setText("");
                thursday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1045TextView.setTextSize(10);
                thursday1045TextView.setText(course.getCourseName());
                thursday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime2() != null && course.getThursdayEndTime2().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1215TextView.setText("");
                thursday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1215TextView.setTextSize(10);
                thursday1215TextView.setText(course.getCourseName());
                thursday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime2() != null && course.getThursdayEndTime2().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1415TextView.setText("");
                thursday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1415TextView.setTextSize(10);
                thursday1415TextView.setText(course.getCourseName());
                thursday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime2() != null && course.getThursdayEndTime2().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1545TextView.setText("");
                thursday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1545TextView.setTextSize(10);
                thursday1545TextView.setText(course.getCourseName());
                thursday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime2() != null && course.getThursdayEndTime2().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1715TextView.setText("");
                thursday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1715TextView.setTextSize(10);
                thursday1715TextView.setText(course.getCourseName());
                thursday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getThursdayEndTime2() != null && course.getThursdayEndTime2().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                thursday1845TextView.setText("");
                thursday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                thursday1845TextView.setTextSize(10);
                thursday1845TextView.setText(course.getCourseName());
                thursday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }

        if (course.getFridayStartTime2().equals("09:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday0930TextView.setText("");
                friday0930TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday0930TextView.setTextSize(10);
                friday0930TextView.setText(course.getCourseName());
                friday0930TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime2().equals("11:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1100TextView.setText("");
                friday1100TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1100TextView.setTextSize(10);
                friday1100TextView.setText(course.getCourseName());
                friday1100TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime2().equals("13:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1300TextView.setText("");
                friday1300TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1300TextView.setTextSize(10);
                friday1300TextView.setText(course.getCourseName());
                friday1300TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime2().equals("14:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1430TextView.setText("");
                friday1430TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1430TextView.setTextSize(10);
                friday1430TextView.setText(course.getCourseName());
                friday1430TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime2().equals("16:00")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1600TextView.setText("");
                friday1600TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1600TextView.setTextSize(10);
                friday1600TextView.setText(course.getCourseName());
                friday1600TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayStartTime2().equals("17:30")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1730TextView.setText("");
                friday1730TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1730TextView.setTextSize(10);
                friday1730TextView.setText(course.getCourseName());
                friday1730TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        // 종료 시간에 대한 처리 추가
        if (course.getFridayEndTime2() != null && course.getFridayEndTime2().equals("10:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1045TextView.setText("");
                friday1045TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1045TextView.setTextSize(10);
                friday1045TextView.setText(course.getCourseName());
                friday1045TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime2() != null && course.getFridayEndTime2().equals("12:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1215TextView.setText("");
                friday1215TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1215TextView.setTextSize(10);
                friday1215TextView.setText(course.getCourseName());
                friday1215TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime2() != null && course.getFridayEndTime2().equals("14:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1415TextView.setText("");
                friday1415TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1415TextView.setTextSize(10);
                friday1415TextView.setText(course.getCourseName());
                friday1415TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime2() != null && course.getFridayEndTime2().equals("15:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1545TextView.setText("");
                friday1545TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1545TextView.setTextSize(10);
                friday1545TextView.setText(course.getCourseName());
                friday1545TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime2() != null && course.getFridayEndTime2().equals("17:15")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1715TextView.setText("");
                friday1715TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1715TextView.setTextSize(10);
                friday1715TextView.setText(course.getCourseName());
                friday1715TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
            }
        }
        if (course.getFridayEndTime2() != null && course.getFridayEndTime2().equals("18:45")) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                // 강의 정보가 없으면 해당 시간표 초기화
                friday1845TextView.setText("");
                friday1845TextView.setBackgroundResource(0); // 배경색 초기화
            } else {
                friday1845TextView.setTextSize(10);
                friday1845TextView.setText(course.getCourseName());
                friday1845TextView.setBackgroundResource(R.drawable.cell_background_orange); // 주황색 배경
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
