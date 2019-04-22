package com.example.yuka;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yuka.fragments.FavoritesFragment;
import com.example.yuka.fragments.ProfileFragment;
import com.example.yuka.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_search:
                        fragment = new SearchFragment();
                        // lets get this bread(toast)... for now.
                        Toast.makeText(MainActivity.this, "Search!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorites:
                        fragment = new FavoritesFragment();
                        // lets get this bread(toast)... for now.
                        Toast.makeText(MainActivity.this, "Favorites!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        fragment = new ProfileFragment();
                        // lets get this bread(toast)... for now.
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        break;
                }
                //transaction = changing frame layout into fragment, thereby putting the chosen fragment as adefault view when in main activity aka bottom navigation
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_search);
    }
}

