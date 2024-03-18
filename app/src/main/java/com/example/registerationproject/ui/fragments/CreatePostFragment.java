package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.example.registerationproject.models.Post;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreatePostFragment extends Fragment {

    private EditText titleEditText;
    private EditText contentEditText;
    private Button submitButton;

    private FirebaseFirestore db;
    private CollectionReference postsRef;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        postsRef = db.collection("posts");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_post, container, false);

        titleEditText = view.findViewById(R.id.edit_text_title);
        contentEditText = view.findViewById(R.id.edit_text_content);
        submitButton = view.findViewById(R.id.button_submit_post);

        submitButton.setOnClickListener(v -> submitPost());

        return view;
    }

    private void submitPost() {
        String title = titleEditText.getText().toString().trim();
        String content = contentEditText.getText().toString().trim();

        if (!title.isEmpty() && !content.isEmpty()) {
            Post post = new Post(title, content);
            postsRef.add(post)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(getContext(), "게시글이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                        // 게시글 등록 후, 이전 화면(CommunityFragment)로 이동
                        getParentFragmentManager().popBackStack();
                    })
                    .addOnFailureListener(e -> Toast.makeText(getContext(), "게시글 등록에 실패했습니다.", Toast.LENGTH_SHORT).show());
        } else {
            Toast.makeText(getContext(), "제목과 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}
