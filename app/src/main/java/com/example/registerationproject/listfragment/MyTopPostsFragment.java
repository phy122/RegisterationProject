/*
package com.example.registerationproject.listfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registerationproject.R;

*/
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyTopPostsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *//*

public class MyTopPostsFragment extends PostListFragment {

    public MyTopPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // My top posts by number of stars
        String myUserId = getUid();
        Query myTopPostsQuery = databaseReference.child("user-posts").child(myUserId)
                .orderByChild("starCount");

        return myTopPostsQuery;
    }
}*/
