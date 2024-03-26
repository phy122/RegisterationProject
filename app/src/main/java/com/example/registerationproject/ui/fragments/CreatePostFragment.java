package com.example.registerationproject.ui.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
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
import com.example.registerationproject.models.Post;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePostFragment extends Fragment {

    private EditText titleEditText;
    private TextView dateTextView;
    private EditText contentEditText;

    private FirebaseFirestore db;
    private CollectionReference postsRef;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 파이어스토어 인스턴스 및 "posts" 컬렉션 레퍼런스 초기화
        db = FirebaseFirestore.getInstance();
        postsRef = db.collection("posts");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_post, container, false);

        // 각각의 EditText를 레이아웃으로부터 찾아와서 초기화
        titleEditText = view.findViewById(R.id.edit_title);
        dateTextView = view.findViewById(R.id.edit_date);
        contentEditText = view.findViewById(R.id.edit_content);

        // 현재 날짜를 설정
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        dateTextView.setText("오늘날짜 : " + sdf.format(new Date()));

        // 저장 버튼에 클릭 리스너 설정
        Button saveButton = view.findViewById(R.id.register_button);
        saveButton.setOnClickListener(v -> savePost());

        return view;
    }

    private void savePost() {
        // EditText로부터 값을 가져옴
        String title = titleEditText.getText().toString();
        String date = dateTextView.getText().toString();
        String content = contentEditText.getText().toString();

        // 커뮤니티 프래그먼트로 값을 전달하기 위한 Intent 생성
        Intent intent = new Intent();
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        intent.putExtra("date", date);

        // 결과를 현재 프래그먼트로 돌려줌
        requireActivity().setResult(RESULT_OK, intent);

        // 파이어스토어에 데이터 추가
        addPostToFirestore(title, content,date);

        // 현재 프래그먼트 종료
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    private void addPostToFirestore(String title, String content, String date) {
        // Fragment가 액티비티에 붙어 있는지 확인
        if (!isAdded()) {
            return;
        }

        // Context 가져오기
        Context context = getContext();
        if (context == null) {
            return;
        }

        // 파이어스토어에 Post 객체 추가
        Post post = new Post(title, content, date);
        postsRef.add(post)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(context, "게시글이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(context, "Failed to add post to Firestore", Toast.LENGTH_SHORT).show();
                });
    }
}
