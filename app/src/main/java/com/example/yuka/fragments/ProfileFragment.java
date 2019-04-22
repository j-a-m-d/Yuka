package com.example.yuka.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuka.Post;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.example.yuka.LoginActivity;
import com.example.yuka.R;

public class ProfileFragment extends Fragment {

    private final String TAG = "ProfileFragment";

    public static final String KEY_USER = "user";
    private ImageView ivProfilePic;
    private TextView tvHandle;
    private Button btnRecentSearch;
    private Button btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivProfilePic = view.findViewById(R.id.ivProfilePic);
        tvHandle = view.findViewById(R.id.tvHandle);
        btnRecentSearch = view.findViewById(R.id.btnRecentSearch);
        btnLogout = view.findViewById(R.id.btnLogout);

        //view the user name

        //tvHandle.setText(R.string.Username);



        //put log out button here
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                goLogin();
            }
        });
    }

    private void goLogin() {
        Log.d(TAG, "Navigating to the Login Activity");
        Intent i= new Intent(getContext(), LoginActivity.class);
        startActivity(i);
    }

}





