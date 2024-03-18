package com.example.registerationproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.registerationproject.R;
import com.example.registerationproject.models.Post;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    private List<Post> postList;

    public PostListAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setPosts(List<Post> posts) {
        postList = posts;
        notifyDataSetChanged();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView contentTextView;
        private TextView likesTextView;
        private Button likeButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.text_view_title);
            contentTextView = itemView.findViewById(R.id.text_view_content);
            likesTextView = itemView.findViewById(R.id.text_view_likes);
            likeButton = itemView.findViewById(R.id.button_like);
        }

        public void bind(Post post) {
            titleTextView.setText(post.getTitle());
            contentTextView.setText(post.getContent());
            likesTextView.setText("Likes: " + post.getLikes());
            likeButton.setOnClickListener(v -> {
                post.increaseLikes(); // 좋아요 수 증가
                likesTextView.setText("Likes: " + post.getLikes());
                likeButton.setEnabled(false); // 중복 좋아요 방지
            });
        }
    }
}
