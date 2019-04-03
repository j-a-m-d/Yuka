package com.example.yuka;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        // lets get this bread(toast)... for now.
                        Toast.makeText(MainActivity.this, "Search!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorites:
                        // lets get this bread(toast)... for now.
                        Toast.makeText(MainActivity.this, "Favorites!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        // lets get this bread(toast)... for now.
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}

