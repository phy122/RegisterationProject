package com.example.registerationproject.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class EditFragment extends Fragment {

    private String titles, dates, contents;
    private int itemnums;
    private TextView date;
    private EditText mtitle, mcontent;
    private FirebaseFirestore db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            titles = bundle.getString("title");
            dates = bundle.getString("date");
            contents = bundle.getString("content");
            itemnums = bundle.getInt("itemnum", 1);
        }

        date = view.findViewById(R.id.modify_date);
        mtitle = view.findViewById(R.id.modify_title);
        mcontent = view.findViewById(R.id.modify_content);

        date.setText(dates);
        mtitle.setText(titles);
        mcontent.setText(contents);

        db = FirebaseFirestore.getInstance();

        // 수정 버튼 클릭 이벤트 처리
        Button modifyButton = view.findViewById(R.id.button_modify);
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyMemo();
            }
        });

        // 삭제 버튼 클릭 이벤트 처리
        Button deleteButton = view.findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMemo();
            }
        });

        return view;
    }

    private void modifyMemo() {
        String modifiedTitle = mtitle.getText().toString();
        String modifiedContent = mcontent.getText().toString();

        // Firestore에 접근할 컬렉션 레퍼런스
        CollectionReference memosRef = db.collection("posts");

        // 해당 제목을 가진 문서를 업데이트하기 위한 쿼리
        memosRef.whereEqualTo("title", titles)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            // 문서의 참조를 얻음
                            DocumentReference docRef = documentSnapshot.getReference();

                            // 업데이트할 데이터 생성
                            Map<String, Object> updates = new HashMap<>();
                            updates.put("title", modifiedTitle);
                            updates.put("content", modifiedContent);

                            // 문서 업데이트
                            docRef.update(updates)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(getContext(), "게시글이 수정되었습니다.", Toast.LENGTH_SHORT).show();
                                            requireActivity().getSupportFragmentManager().popBackStack();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getContext(), "게시글 수정에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "게시글 수정에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    // 메모 삭제 메서드
    private void deleteMemo() {
        // Firestore에 접근할 컬렉션 레퍼런스
        CollectionReference memosRef = db.collection("posts");

        // 해당 제목을 가진 문서를 삭제하기 위한 쿼리
        memosRef.whereEqualTo("title", titles)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            // 문서의 참조를 얻음
                            DocumentReference docRef = documentSnapshot.getReference();

                            // 문서 삭제
                            docRef.delete()
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(getContext(), "게시글이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                                            requireActivity().getSupportFragmentManager().popBackStack();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getContext(), "게시글 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "게시글 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    // 수정된 데이터를 커뮤니티 프래그먼트로 전달하는 메서드
    private void sendUpdatedDataToCommunityFragment(String updatedTitle, String updatedContent) {
        Intent intent = new Intent();
        intent.putExtra("updatedTitle", updatedTitle);
        intent.putExtra("updatedContent", updatedContent);
        requireActivity().setResult(Activity.RESULT_OK, intent);
    }
}
