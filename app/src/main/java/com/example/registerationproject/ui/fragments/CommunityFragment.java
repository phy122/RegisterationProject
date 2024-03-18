package com.example.registerationproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registerationproject.R;
import com.example.registerationproject.adapter.PostListAdapter;
import com.example.registerationproject.models.Post;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    private Button createPostButton;
    private RecyclerView recyclerView;
    private PostListAdapter adapter;

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
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        createPostButton = view.findViewById(R.id.button_create_post);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PostListAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // CreatePostFragment로 이동하는 코드
        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment createPostFragment = new CreatePostFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, createPostFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        loadPosts();

        return view;
    }

    private void loadPosts() {
        postsRef.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<Post> postList = new ArrayList<>();
                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        Post post = document.toObject(Post.class);
                        postList.add(post);
                    }
                    adapter.setPosts(postList);
                })
                .addOnFailureListener(e -> Toast.makeText(getContext(), "게시글을 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show());
    }
}
