package com.example.registerationproject.adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.registerationproject.R;
import com.example.registerationproject.models.Post;
import com.example.registerationproject.ui.fragments.EditFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    private List<Post> postList;
    private Context context;

    public PostListAdapter(Context context,List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view);
        return viewHolder;
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

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView contentTextView;
        private TextView dateTextView;
        private TextView likesTextView;
        private Button likeButton;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.community_title);
            contentTextView = itemView.findViewById(R.id.community_content);
            likesTextView = itemView.findViewById(R.id.community_likes);
            dateTextView = itemView.findViewById(R.id.community_date);
            likeButton = itemView.findViewById(R.id.button_like);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // EditFragment 인스턴스 생성
                    EditFragment editFragment = new EditFragment();

                    // EditFragment로 전달할 데이터를 Bundle에 담습니다.
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", getAdapterPosition());
                    bundle.putString("title", postList.get(getAdapterPosition()).getTitle());
                    bundle.putString("content", postList.get(getAdapterPosition()).getContent());
                    bundle.putString("date", postList.get(getAdapterPosition()).getDate());
                    bundle.putInt("itemnum", getAdapterPosition());
                    editFragment.setArguments(bundle);

                    // EditFragment를 표시하기 위해 FragmentManager를 사용합니다.
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment, editFragment); // fragment_container는 EditFragment를 표시할 프레임 레이아웃의 ID입니다.
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }

        public void bind(Post post) {
            titleTextView.setText(post.getTitle());
            contentTextView.setText(post.getContent());
            dateTextView.setText(post.getDate());
            likesTextView.setText("" + post.getLikes());
            likeButton.setOnClickListener(v -> {
                post.increaseLikes(); // 좋아요 수 증가
                likesTextView.setText("Likes: " + post.getLikes());
                likeButton.setEnabled(false); // 중복 좋아요 방지
            });
        }
    }

}
