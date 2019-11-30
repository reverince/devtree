package io.github.reverince.devtree.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.github.reverince.devtree.R;
import io.github.reverince.devtree.rcv.BoardGridAdapter;
import io.github.reverince.devtree.rcv.PostRecyclerAdapter;

public class MyBoardActivity extends AppCompatActivity {
	// 테스트용 임시 데이터
	final String[] cellStrings = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii" };
	final boolean[] cellCleared = { false, true, true, true, false, false, false, true, false };
	final String[] taskTitles = { "과제 01", "과제 02", "과제 03", "과제 04", "과제 05", "과제 06" };
	final String[] taskContents = { "01 설명", "02 설명", "03 설명", "04 설명", "05 설명", "06 설명" };
	final String[] postAuthors = {"홍길동", "유튜버", "라인", "구름"};
	final String[] postContents = {"dasas dasdkoasp dow kdp", "adk wapdakw odaw kdp", "awpkpvoe peoap domapo dmdpw", "awodka pwd okwd"};
	final String[] postLinks = {"https://goorm.edu", "https://naver.com", "https://google.com", "https://youtube.com"};

	BottomNavigationView bottomNavigationView;
	GridView boardGrid;
	View selectedView = null;
	int lastPosition;
	TextView taskTitleText, taskContentText;
	ToggleButton postToggle;
	Button submitBtn;

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
		BoardGridAdapter boardGridAdapter = new BoardGridAdapter(this, cellStrings, cellCleared);
		boardGrid.setAdapter(boardGridAdapter);
		boardGrid.setOnItemClickListener(onCellClickListener);

		taskTitleText = findViewById(R.id.text_task_title);
		taskContentText = findViewById(R.id.text_task_content);

		postToggle = findViewById(R.id.btn_post);
		postToggle.setOnCheckedChangeListener(onPostToggleCheckedChangeListener);
		submitBtn = findViewById(R.id.btn_submit);
		submitBtn.setOnClickListener(onSubmitBtnClickListener);

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
						overridePendingTransition(0, 0);
						break;
					case R.id.action_home:
						finish();
						break;
					case R.id.action_profile:
						startActivity(new Intent(MyBoardActivity.this, MyPageActivity.class));
						overridePendingTransition(0, 0);
						finish();
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

			if (selectedView != null) {
				if (cellCleared[lastPosition]) {
					selectedView.setBackgroundColor(ContextCompat.getColor(MyBoardActivity.this, R.color.colorPrimary));
				} else {
					selectedView.setBackgroundColor(ContextCompat.getColor(MyBoardActivity.this, R.color.background));
				}
			}
			view.setBackgroundColor(ContextCompat.getColor(MyBoardActivity.this, R.color.colorAccent));
			selectedView = view;
			lastPosition = position;

			try {
				taskTitleText.setText(taskTitles[position]);
				taskContentText.setText(taskContents[position]);
			} catch (ArrayIndexOutOfBoundsException e) {
				Log.e(this.toString(), "인덱스 초과");
			}
		}
	};

	private ToggleButton.OnCheckedChangeListener onPostToggleCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (isChecked) {
				postRecyclerView.setVisibility(View.VISIBLE);
			} else {
				postRecyclerView.setVisibility(View.GONE);
			}
		}
	};

	private View.OnClickListener onSubmitBtnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//TODO: 다이얼로그
			FragmentManager fm = getSupportFragmentManager();
			SubmitTaskDialogFragment submitTaskDialogFragment = new SubmitTaskDialogFragment();
			submitTaskDialogFragment.show(fm, this.toString());
		}
	};

}
