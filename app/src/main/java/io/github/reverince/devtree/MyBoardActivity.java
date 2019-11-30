package io.github.reverince.devtree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class MyBoardActivity extends AppCompatActivity {
    // 테스트용 임시 데이터
    final String[] cellStrings = { "aa", "bb", "cc", "dd", "ee", "ff" };
    final String[] taskTitles = { "과제 01", "과제 02", "과제 03" };
    final String[] taskContents = { "01 ", "02 ", "03 " };
    final String[] postAuthors = { "홍길동", "유튜버", "라인", "구름" };
    final String[] postContents = { "dasas dasdkoasp dow kdp", "adk wapdakw odaw kdp", "awpkpvoe peoap domapo dmdpw", "awodka pwd okwd" };
    final String[] postLinks = { "https://goorm.edu", "https://naver.com", "https://google.com", "https://youtube.com" };

    BottomNavigationView bottomNavigationView;
    GridView boardGrid;
    TextView taskTitleText, taskContentText;

    RecyclerView postRecyclerView;
    RecyclerView.Adapter postRecyclerViewAdapter;
    RecyclerView.LayoutManager postRecyclerViewLayoutManager;

    int currentTaskIdx = 0;  // 지금 선택된 과제 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_board);
        setTitle("진행 중인 보드 액티비티");  //TODO: 보드 제목 받아오기

        boardGrid = findViewById(R.id.grid_board);
        boardGrid.setAdapter(new BoardAdapter(this, cellStrings));
        boardGrid.setOnItemClickListener(onCellClickListener);

        taskTitleText = findViewById(R.id.text_task_title);
        taskContentText = findViewById(R.id.text_task_content);

        postRecyclerView = findViewById(R.id.recycler_posts);
        postRecyclerView.setHasFixedSize(false);
        postRecyclerViewLayoutManager = new LinearLayoutManager(this);
        postRecyclerView.setLayoutManager(postRecyclerViewLayoutManager);
        postRecyclerViewAdapter = new PostRecyclerAdapter(postAuthors, postContents, postLinks);
        postRecyclerView.setAdapter(postRecyclerViewAdapter);

        bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_board:
                        break;
                    case R.id.action_home:
                        Intent intent = new Intent(MyBoardActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.action_profile:
                        //Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
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
            Toast.makeText(MyBoardActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            try {
                taskTitleText.setText(taskTitles[position]);
                taskContentText.setText(taskContents[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                Log.e(this.toString(), "인덱스 초과");
            }
        }
    };

}
