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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.example.registerationproject.R;
import com.example.registerationproject.models.Post;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditFragment extends Fragment {

    private EditText titleEditText;
    private EditText contentEditText;
    private Button updatePostButton;
    private Button deletePostButton;

    private CollectionReference postsRef;
    private String postId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postsRef = FirebaseFirestore.getInstance().collection("posts");
        postId = getArguments().getString("postId");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        titleEditText = view.findViewById(R.id.edit_text_title);
        contentEditText = view.findViewById(R.id.edit_text_content);
        updatePostButton = view.findViewById(R.id.button_update_post);
        deletePostButton = view.findViewById(R.id.button_delete_post);

        // 게시글 불러와서 EditText에 설정하기 (생략)

        updatePostButton.setOnClickListener(v -> updatePost());
        deletePostButton.setOnClickListener(v -> confirmDeletePost());

        return view;
    }

    private void updatePost() {
        String title = titleEditText.getText().toString().trim();
        String content = contentEditText.getText().toString().trim();
        if (!title.isEmpty() && !content.isEmpty()) {
            // 게시글 업데이트 구현하기 (생략)
        } else {
            Toast.makeText(getContext(), "제목과 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }

    private void confirmDeletePost() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("게시글 삭제");
        builder.setMessage("정말로 게시글을 삭제하시겠습니까?");
        builder.setPositiveButton("삭제", (dialog, which) -> deletePost());
        builder.setNegativeButton("취소", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    private void deletePost() {
        // 게시글 삭제 구현하기 (생략)
    }
}
