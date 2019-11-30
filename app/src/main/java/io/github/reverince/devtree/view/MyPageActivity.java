package io.github.reverince.devtree.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import io.github.reverince.devtree.R;
import io.github.reverince.devtree.data.Board;
import io.github.reverince.devtree.data.Post;
import io.github.reverince.devtree.rcv.BoardAdapter;
import io.github.reverince.devtree.rcv.PostAdapter;

public class MyPageActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private RecyclerView mCompleteBoardView;
    private RecyclerView mPostView;
    private ImageView mProfile;
    private TextView mTextNumberOfClearBoard;
    private TextView mTextNumberOfTaskValue;
    private TextView mTextStackName;
    private List<Post> postList = new ArrayList<>();
    private List<Board> boardList = new ArrayList<>();
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        mTextNumberOfClearBoard = findViewById(R.id.textNumberOfClearBoard);
        mTextNumberOfTaskValue = findViewById(R.id.textNumberOfTaskValue);
        mTextStackName = findViewById(R.id.textStackName);
        mCompleteBoardView = findViewById(R.id.completeBoardView);
        mPostView = findViewById(R.id.postView);
        mProfile = findViewById(R.id.imageProfile);

        mProfile.setBackground(new ShapeDrawable(new OvalShape()));
        mProfile.setClipToOutline(true);

//        db = FirebaseFirestore.getInstance();

//        db.collection();

        LinearLayoutManager mHorizontalLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        mCompleteBoardView.setLayoutManager(mHorizontalLayoutManager);
        boardList.add(new Board("레이아웃 다루기", "2019.11.30", 5, 4));
        boardList.add(new Board("채팅봇 만들기", "2019.10.05", 3, 5));
        BoardAdapter myBoardAdapter = new BoardAdapter(this, boardList);
        mCompleteBoardView.setAdapter(myBoardAdapter);

        myBoardAdapter.setOnItemClickListener(new BoardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BoardAdapter.BoardViewHolder holder, View view, int position) {
                Board item = boardList.get(position);
                Toast.makeText(MyPageActivity.this, "아이템 클릭! 테마명은 "+item.getThemeName(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), );
            }
        });

        LinearLayoutManager mVerticalLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mPostView.setLayoutManager(mVerticalLayoutManager);
        postList.add(new Post("null","포스트 요약글1"));
        postList.add(new Post("null","포스트 요약글2"));
        postList.add(new Post("null","포스트 요약글3"));
        postList.add(new Post("null","포스트 요약글4"));

        PostAdapter postAdapter = new PostAdapter(this, postList);
        mPostView.setAdapter(postAdapter);

        postAdapter.setOnItemClickListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PostAdapter.PostViewHolder holder, View view, int position) {
                Post item = postList.get(position);
            }
        });

        bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_board:
                        startActivity(new Intent(MyPageActivity.this, MyBoardActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                    case R.id.action_home:
                        startActivity(new Intent(MyPageActivity.this, Main2Activity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                    case R.id.action_profile:
                        //Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        overridePendingTransition(0, 0);
                        break;
                }
                return true;
            }
        });
    }
}
