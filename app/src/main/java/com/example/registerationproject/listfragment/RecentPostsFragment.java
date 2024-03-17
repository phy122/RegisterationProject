/*
package com.example.registerationproject.listfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registerationproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

*/
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecentPostsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *//*

public class RecentPostsFragment extends PostListFragment {

    public RecentPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys
        Query recentPostsQuery = databaseReference.child("posts")
                .limitToFirst(100);
        // [END recent_posts_query]

        return recentPostsQuery;
    }
}*/
