package com.example.registerationproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registerationproject.R;
import com.example.registerationproject.models.Course;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class StatisticsAdapter extends BaseAdapter {
    private Context context;
    private List<Course> courses;
    private LayoutInflater inflater;
    private FirebaseFirestore db;

    public StatisticsAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
        this.inflater = LayoutInflater.from(context);
        this.db = FirebaseFirestore.getInstance();
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.statistics, parent, false); // 레이아웃 파일 이름 수정
        }

        Course course = courses.get(position);

        TextView courseNameTextView = view.findViewById(R.id.courseName);
        TextView courseDivideTextView = view.findViewById(R.id.courseDivide);
        TextView courseGradeTextView = view.findViewById(R.id.courseGrade);
        TextView coursePersonnelTextView = view.findViewById(R.id.coursePersonnel);
        TextView courseLimitTextView = view.findViewById(R.id.courseLimit);
        TextView courseRateTextView = view.findViewById(R.id.courseRate);
        Button deleteButton = view.findViewById(R.id.deleteButton);

        // 강의 정보 설정
        courseNameTextView.setText(course.getCourseName());
        courseDivideTextView.setText(course.getDivision());
        courseGradeTextView.setText(course.getGrade());
        coursePersonnelTextView.setText(String.valueOf(course.getPersonnel()));
        courseLimitTextView.setText(String.valueOf(course.getLimit()));
        double courseRate = (double) course.getPersonnel() / course.getLimit();
        courseRateTextView.setText(String.format("%.2f", courseRate));

        // 삭제 버튼 클릭 리스너
        deleteButton.setOnClickListener(v -> {
            String courseId = course.getDocumentId();

            db.collection("schedules").document(courseId)
                    .delete()
                    .addOnSuccessListener(aVoid -> {
                        courses.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(context, "강의가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(context, "강의 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    });
        });

        return view;
    }

    // 어댑터의 courses 리스트를 업데이트하고 변경 사항을 반영합니다.
    public void updateCourses(List<Course> newCourses) {
        this.courses.clear();
        this.courses.addAll(newCourses);
        notifyDataSetChanged();
    }
}


