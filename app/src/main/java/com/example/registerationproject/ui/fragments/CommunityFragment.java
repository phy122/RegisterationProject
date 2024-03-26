package com.example.registerationproject.ui.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registerationproject.R;
import com.example.registerationproject.adapter.PostListAdapter;
import com.example.registerationproject.models.Post;
import com.example.registerationproject.ui.fragments.CreatePostFragment;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    private RecyclerView recyclerView;
    private PostListAdapter adapter;

    private FirebaseFirestore db;
    private CollectionReference postsRef;
    private List<Post> postList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        postsRef = db.collection("posts");
        postList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        setHasOptionsMenu(true);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new PostListAdapter(requireContext(), postList);
        recyclerView.setAdapter(adapter);

        Button addButton = view.findViewById(R.id.btn_write_post);
        addButton.setOnClickListener(v -> openCreatePostFragment());

        // 메모 데이터 가져오기
        fetchPosts();

        return view;
    }
    private void openCreatePostFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        CreatePostFragment createPostFragment = new CreatePostFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, createPostFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");
            String date = data.getStringExtra("date");
            Toast.makeText(requireContext(), title + "," + content, Toast.LENGTH_SHORT).show();

            // 파이어스토어에 Post 객체 추가
            addPostToFirestore(title, date, content);
        }
    }

    private void fetchPosts() {
        postsRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                postList.clear();
                for (DocumentSnapshot document : task.getResult()) {
                    Post post = document.toObject(Post.class);
                    postList.add(post);
                }
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(requireContext(), "Failed to fetch posts", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addPostToFirestore(String title, String date, String content) {
        Post post = new Post(title, content,date);
        postsRef.add(post)
                .addOnSuccessListener(documentReference -> {
                    postList.add(post);
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(requireContext(), "Failed to add post to Firestore", Toast.LENGTH_SHORT).show();
                });
    }
}
