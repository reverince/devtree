package io.github.reverince.devtree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BoardPreviewActivity extends AppCompatActivity {
    // 테스트용 임시 데이터
    final String[] cellStrings = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii" };
    final String[] taskTitles = { "과제 01", "과제 02", "과제 03", "과제 04", "과제 05", "과제 06" };
    final String[] taskContents = { "01 설명", "02 설명", "03 설명", "04 설명", "05 설명", "06 설명" };

    BottomNavigationView bottomNavigationView;
    GridView boardGrid;
    TextView taskTitleText, taskContentText;

    int currentTaskIdx = 0;  // 지금 선택된 과제 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_preview);
        setTitle("보드 미리보기 액티비티");  //TODO: 보드 제목 받아오기

        boardGrid = findViewById(R.id.grid_board);
        BoardGridAdapter boardGridAdapter = new BoardGridAdapter(this, cellStrings);
        boardGrid.setAdapter(boardGridAdapter);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_board_preview, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                //TODO: 진행 중인 보드에 지금 보드 추가
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private AdapterView.OnItemClickListener onCellClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            currentTaskIdx = position;
            Toast.makeText(BoardPreviewActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            try {
                taskTitleText.setText(taskTitles[position]);
                taskContentText.setText(taskContents[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                Log.e(this.toString(), "ArrayIndexOutOfBoundsException");
            }
        }
    };

}
