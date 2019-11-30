package io.github.reverince.devtree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BoardPreviewActivity extends AppCompatActivity {
    final String[] titles = { "과제 01", "과제 02", "과제 03" };
    final String[] contents = { "01 ", "02 ", "03 " };

    BottomNavigationView bottomNavigationView;
    GridView boardGrid;
    TextView taskTitleText, taskContentText;

    int currentTaskIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_preview);
        setTitle("보드 미리보기 액티비티");

        boardGrid = findViewById(R.id.grid_board);
        boardGrid.setAdapter(new BoardAdapter(this));
        boardGrid.setOnItemClickListener(onCellClickListener);

        taskTitleText = findViewById(R.id.text_task_title);
        taskContentText = findViewById(R.id.text_task_content);

        bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.action_board:
                        intent = new Intent(BoardPreviewActivity.this, MyBoardActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.action_home:
                        intent = new Intent(BoardPreviewActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.action_profile:
                        //intent = new Intent(MainActivity.this, ProfileActivity.class);
                        break;
                }
                return true;
            }
        });
    }

    private AdapterView.OnItemClickListener onCellClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            currentTaskIdx = position;
            Toast.makeText(BoardPreviewActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            try {
                taskTitleText.setText(titles[position]);
                taskContentText.setText(contents[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                Log.e(this.toString(), "ArrayIndexOutOfBoundsException");
            }
        }
    };

}
