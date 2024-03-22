package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.example.registerationproject.models.Course;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {

    private Spinner gradeSpinner, divisionSpinner, majorSpinner, professorSpinner, creditSpinner, courseSpinner;
    private Button searchButton;
    private ListView courseListView;

    private FirebaseFirestore db;

    public CourseFragment() {
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
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        gradeSpinner = view.findViewById(R.id.gradeSpinner);
        divisionSpinner = view.findViewById(R.id.divisionSpinner);
        creditSpinner = view.findViewById(R.id.creditSpinner);
        majorSpinner = view.findViewById(R.id.majorSpinner);
        professorSpinner = view.findViewById(R.id.professorSpinner);
        courseSpinner = view.findViewById(R.id.courseSpinner);
        searchButton = view.findViewById(R.id.searchButton);

        courseListView = view.findViewById(R.id.courseListView);

        // majorSpinner에 아이템 추가
        ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.major, android.R.layout.simple_spinner_item);
        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majorSpinner.setAdapter(majorAdapter);

        // gradeSpinner에 아이템 추가
        ArrayAdapter<CharSequence> gradeAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.grade, android.R.layout.simple_spinner_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(gradeAdapter);

        // divisionSpinner에 아이템 추가
        ArrayAdapter<CharSequence> divisionAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.division, android.R.layout.simple_spinner_item);
        divisionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        divisionSpinner.setAdapter(divisionAdapter);

        ArrayAdapter<CharSequence> creditAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.credit, android.R.layout.simple_spinner_item);
        creditAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        creditSpinner.setAdapter(creditAdapter);

        ArrayAdapter<CharSequence> courseAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.course, android.R.layout.simple_spinner_item);
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSpinner.setAdapter(courseAdapter);

        // 교수명 스피너에 아이템 추가
        ArrayAdapter<CharSequence> professorAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.professor, android.R.layout.simple_spinner_item);
        professorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        professorSpinner.setAdapter(professorAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCourses();
            }
        });

        return view;
    }

    private void searchCourses() {
        // 사용자가 선택한 값들을 가져옴
        String selectedGrade = gradeSpinner.getSelectedItemPosition() > 0 ? gradeSpinner.getSelectedItem().toString() : null;
        String selectedDivision = divisionSpinner.getSelectedItemPosition() > 0 ? divisionSpinner.getSelectedItem().toString() : null;
        String selectedCredit = creditSpinner.getSelectedItemPosition() > 0 ? creditSpinner.getSelectedItem().toString() : null;
        String selectedMajor = majorSpinner.getSelectedItemPosition() > 0 ? majorSpinner.getSelectedItem().toString() : null;
        String selectedProfessor = professorSpinner.getSelectedItemPosition() > 0 ? professorSpinner.getSelectedItem().toString() : null;

        // Firestore에서 강의를 검색하여 결과를 표시하는 코드
        Query query = db.collection("courses");

        if (selectedGrade != null) {
            query = query.whereEqualTo("grade", selectedGrade);
        }
        if (selectedDivision != null) {
            query = query.whereEqualTo("division", selectedDivision);
        }
        if (selectedCredit != null) {
            query = query.whereEqualTo("credit", selectedCredit);
        }
        if (selectedMajor != null) {
            query = query.whereEqualTo("major", selectedMajor);
        }
        if (selectedProfessor != null) {
            query = query.whereEqualTo("professor", selectedProfessor);
        }

        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Course> courseList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // 각 문서에서 필드 값들을 가져와서 Course 객체로 만들어 리스트에 추가
                                Course course = document.toObject(Course.class);
                                courseList.add(course);
                            }
                            // 검색 결과를 리스트뷰에 표시
                            displaySearchResults(courseList);
                        } else {
                            // 검색 실패 시 처리
                            showToast("검색에 실패했습니다. 다시 시도해주세요.");
                        }
                    }
                });
    }

    private void displaySearchResults(List<Course> courseList) {
        if (courseList.size() > 0) {
            ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(requireContext(), android.R.layout.simple_list_item_1, courseList) {
                @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View itemView = convertView;
                    if (itemView == null) {
                        itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_course, parent, false);
                    }

                    // 각 뷰에 데이터 설정
                    Course course = getItem(position);
                    TextView courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
                    TextView professorTextView = itemView.findViewById(R.id.professorTextView);
                    TextView creditTextView = itemView.findViewById(R.id.creditTextView);
                    TextView majorTextView = itemView.findViewById(R.id.majorTextView);
                    TextView gradeTextView = itemView.findViewById(R.id.gradeTextView);
                    TextView divisionTextView = itemView.findViewById(R.id.divisionTextView);
                    // 시간 관련 TextView 추가
                    TextView timeTextView1 = itemView.findViewById(R.id.timeTextView1);
                    TextView timeTextView2 = itemView.findViewById(R.id.timeTextView2);

                    courseNameTextView.setText(course.getCourseName());
                    gradeTextView.setText(course.getGrade());
                    divisionTextView.setText(course.getDivision());
                    creditTextView.setText(course.getCredit());
                    majorTextView.setText(course.getMajor());
                    professorTextView.setText(course.getProfessor());
                    timeTextView1.setText(course.getDayAndTimeRange());
                    timeTextView2.setText(course.getDayAndTimeRange());

                    // 시간표에 추가하는 버튼
                    Button addToTimetableButton = itemView.findViewById(R.id.addToTimetableButton);
                    addToTimetableButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Bundle 객체 생성
                            Bundle bundle = new Bundle();

                            // 선택된 강의 정보 저장
                            bundle.putSerializable("course", course);

                            // ScheduleFragment 연결
                            ScheduleFragment scheduleFragment = new ScheduleFragment();
                            scheduleFragment.setArguments(bundle);

                            // Fragment 전환
                            requireActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment, scheduleFragment)
                                    .addToBackStack(null)
                                    .commit();

                            // 강의 추가 성공 메시지 표시
                            showToast("시간표에 \"" + course.getCourseName() + "\" 강의가 추가되었습니다.");
                        }
                    });

                    return itemView;
                }
            };
            courseListView.setAdapter(adapter);
        } else {
            showToast("검색 결과가 없습니다.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

}

// 시간 정보
