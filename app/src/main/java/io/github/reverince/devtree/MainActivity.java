package io.github.reverince.devtree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_board:
                        Intent intent = new Intent(MainActivity.this, MyBoardActivity.class);
                        startActivity(intent);
                        //finish();
                        break;
                    case R.id.action_home:
                        break;
                    case R.id.action_profile:
                        //Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        break;
                }
                return true;
            }
        });
    }

}
