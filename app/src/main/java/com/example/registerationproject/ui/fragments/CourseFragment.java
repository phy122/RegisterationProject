package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {

    private Spinner gradeSpinner, divisionSpinner, creditSpinner, majorSpinner, professorSpinner;

    private ArrayAdapter<String> gradeAdapter, divisionAdapter, creditAdapter, majorAdapter, professorAdapter;

    private FirebaseFirestore db;

    private ListView courseListView;

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

        gradeSpinner = view.findViewById(R.id.gradeSpinner);
        divisionSpinner = view.findViewById(R.id.divisionSpinner);
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
        ArrayAdapter<CharSequence> creditAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.credit, android.R.layout.simple_spinner_item);
        creditAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        creditSpinner.setAdapter(creditAdapter);

        // 교수명 스피너에 아이템 추가
        ArrayAdapter<CharSequence> professorAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.professor, android.R.layout.simple_spinner_item);
        professorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        professorSpinner.setAdapter(professorAdapter);

        // 스피너 값 변경 이벤트 리스너 설정
        setSpinnerListeners();

        return view;
    }

    private void searchCourses() {
        // 사용자가 선택한 값들을 가져옴
        String selectedGrade = gradeSpinner.getSelectedItem().toString();
        String selectedDivision = divisionSpinner.getSelectedItem().toString();
        String selectedCredit = creditSpinner.getSelectedItem().toString();
        String selectedMajor = majorSpinner.getSelectedItem().toString();
        String selectedProfessor = professorSpinner.getSelectedItem().toString();

        // Firestore에서 강의를 검색하여 결과를 표시하는 코드
        db.collection("courses")
                .whereEqualTo("grade", selectedGrade)
                .whereEqualTo("division", selectedDivision)
                .whereEqualTo("credit", selectedCredit)
                .whereEqualTo("major", selectedMajor)
                .whereEqualTo("professor", selectedProfessor) // 교수명 추가
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> courseList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // 강의 정보를 가져와서 리스트에 추가
                                String courseName = document.getString("name");
                                courseList.add(courseName);
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

    private void setSpinnerListeners() {
        // 각 스피너의 선택 여부를 확인하고 선택된 값이 있는 경우에만 검색을 수행하도록 설정
        majorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchCourses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do
            }
        });

        gradeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchCourses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do
            }
        });

        divisionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchCourses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do
            }
        });

        creditSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchCourses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do
            }
        });

        professorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchCourses();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do
            }
        });
    }

    private void displaySearchResults(List<String> courseList) {
        // 검색 결과를 리스트뷰에 표시하는 코드
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, courseList);
        courseListView.setAdapter(adapter);
    }

    private void showToast(String message) {
        // 사용자에게 토스트 메시지로 알림을 표시하는 코드
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}