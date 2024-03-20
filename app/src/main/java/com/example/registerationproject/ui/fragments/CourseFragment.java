package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {

    private Spinner gradeSpinner, divisionSpinner, courseSpinner, majorSpinner, professorSpinner,creditSpinner;

    private ArrayAdapter<String> gradeAdapter, divisionAdapter, creditAdapter, majorAdapter, professorAdapter,courseAdapter;

    private FirebaseFirestore db;

    private ListView courseListView;

    private Button searchbutton;

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

        courseListView = view.findViewById(R.id.courseListView);

        courseListView = view.findViewById(R.id.courseListView);
        gradeSpinner = view.findViewById(R.id.gradeSpinner);
        divisionSpinner = view.findViewById(R.id.divisionSpinner);
        courseSpinner = view.findViewById(R.id.courseSpinner);
        creditSpinner = view.findViewById(R.id.creditSpinner);
        majorSpinner = view.findViewById(R.id.majorSpinner);
        professorSpinner = view.findViewById(R.id.professorSpinner);

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

        // creditSpinner에 아이템 추가
        ArrayAdapter<CharSequence> courseAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.course, android.R.layout.simple_spinner_item);
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSpinner.setAdapter(courseAdapter);

        ArrayAdapter<CharSequence> creditAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.credit, android.R.layout.simple_spinner_item);
        creditAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        creditSpinner.setAdapter(creditAdapter);

        // 교수명 스피너에 아이템 추가
        ArrayAdapter<CharSequence> professorAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.professor, android.R.layout.simple_spinner_item);
        professorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        professorSpinner.setAdapter(professorAdapter);

        searchbutton = view.findViewById(R.id.searchButton);
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchCourses();
            }
        });

        // 스피너 값 변경 이벤트 리스너 설정
        setSpinnerListeners();


        return view;
    }


    private void searchCourses() {
        Log.d("CourseFragment", "SearchCourses method called"); // 메서드 호출 시 로그 출력

        // 사용자가 선택한 값들을 가져옴
        String selectedGrade = gradeSpinner.getSelectedItemPosition() > 0 ? gradeSpinner.getSelectedItem().toString() : null;
        String selectedDivision = divisionSpinner.getSelectedItemPosition() > 0 ? divisionSpinner.getSelectedItem().toString() : null;
        String selectedCredit = creditSpinner.getSelectedItemPosition() > 0 ? creditSpinner.getSelectedItem().toString() : null;
        String selectedMajor = majorSpinner.getSelectedItemPosition() > 0 ? majorSpinner.getSelectedItem().toString() : null;
        String selectedCourse = courseSpinner.getSelectedItemPosition() > 0 ? courseSpinner.getSelectedItem().toString() : null;
        String selectedProfessor = professorSpinner.getSelectedItemPosition() > 0 ? professorSpinner.getSelectedItem().toString() : null;

        Log.d("CourseFragment", "Selected values: " + selectedGrade + ", " + selectedDivision + ", " + selectedCredit + ", " + selectedMajor + ", " + selectedCourse + ", " + selectedProfessor);

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
        if (selectedCourse != null) {
            query = query.whereEqualTo("course", selectedCourse);
        }

        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d("CourseFragment", "Firestore query successful"); // 쿼리 성공 시 로그 출력
                            List<String> courseInfoList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // 각 문서에서 필드 값들을 가져와서 문자열로 조합하여 리스트에 추가
                                String courseInfo = "강의 이름: " + document.getString("course") +
                                        ", 학년: " + document.getString("grade") +
                                        ", 분반: " + document.getString("division") +
                                        ", 학점: " + document.getString("credit") +
                                        ", 전공: " + document.getString("major") +
                                        ", 교수: " + document.getString("professor");
                                courseInfoList.add(courseInfo);
                            }
                            // 검색 결과를 리스트뷰에 표시
                            displaySearchResults(courseInfoList);
                        } else {
                            // 검색 실패 시 처리
                            Log.d("CourseFragment", "Firestore query failed"); // 쿼리 실패 시 로그 출력
                            showToast("검색에 실패했습니다. 다시 시도해주세요.");
                        }
                    }
                });
    }

    private void setSpinnerListeners() {
        AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 항목의 위치(position)이 0이면(첫 번째 항목이면) 아무런 작업을 하지 않음
                if (position == 0) {
                    return;
                }
                // 검색 메서드 호출
                searchCourses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do
            }
        };

        // 각 스피너에 동일한 리스너를 설정하여 하나의 스피너만 선택되었을 때에만 검색을 수행하도록 함
        majorSpinner.setOnItemSelectedListener(spinnerListener);
        gradeSpinner.setOnItemSelectedListener(spinnerListener);
        divisionSpinner.setOnItemSelectedListener(spinnerListener);
        creditSpinner.setOnItemSelectedListener(spinnerListener);
        courseSpinner.setOnItemSelectedListener(spinnerListener);
        professorSpinner.setOnItemSelectedListener(spinnerListener);
    }

    private void displaySearchResults(List<String> courseList) {
        // courseList의 크기를 확인하여 데이터가 있는지 확인합니다.
        if (courseList.size() > 0) {
            // courseList에 데이터가 있을 때의 처리
            Log.d("CourseFragment", "Displaying search results: " + courseList.size() + " items");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, courseList);
            courseListView.setAdapter(adapter);
        } else {
            // courseList가 비어 있을 때의 처리
            Log.d("CourseFragment", "No search results found");
            // 적절한 처리를 수행하세요. 예를 들어 사용자에게 메시지를 표시하거나 다른 작업을 수행할 수 있습니다.
        }
    }


    private void showToast(String message) {
        // 사용자에게 토스트 메시지로 알림을 표시하는 코드
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}