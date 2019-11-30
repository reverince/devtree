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

import java.util.ArrayList;
import java.util.List;

import io.github.reverince.devtree.R;
import io.github.reverince.devtree.rcv.BoardGridAdapter;
import io.github.reverince.devtree.rcv.PostRecyclerAdapter;

public class MyBoardActivity extends AppCompatActivity {
	// 테스트용 임시 데이터
	final String[] cellStrings = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii" };
	public static boolean[] cellCleared = { false, true, true, true, false, false, false, true, false };
	final String[] taskTitles = { "과제 01", "과제 02", "과제 03", "과제 04", "과제 05", "과제 06", "과제 07", "과제 08", "과제 09" };
	final String[] taskContents = { "01 설명", "02 설명", "03 설명", "04 설명", "05 설명", "06 설명", "08 설명", "08 설명", "09 설명" };
	public static List<String> postAuthors = new ArrayList<>();
	public static List<String> postContents = new ArrayList<>();
	public static List<String> postLinks = new ArrayList<>();

	BottomNavigationView bottomNavigationView;
	GridView boardGrid;
	public static BoardGridAdapter boardGridAdapter;
	View selectedView = null;
	int lastPosition;
	TextView taskTitleText, taskContentText;
	ToggleButton postToggle;
	Button submitBtn;

	RecyclerView postRecyclerView;
	public static RecyclerView.Adapter postRecyclerViewAdapter;
	RecyclerView.LayoutManager postRecyclerViewLayoutManager;

	public static int currentTaskIdx = 0;  // 지금 선택된 과제 번호

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_board);
		setTitle("진행 중인 보드 액티비티");  //TODO: 보드 제목 받아오기

		postAuthors.add("홍길동");
		postContents.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ");
		postLinks.add("https://goorm.edu");
		postAuthors.add("유튜버");
		postContents.add("the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make");
		postLinks.add("https://naver.com");
		postAuthors.add("라인");
		postContents.add("a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially");
		postLinks.add("https://nhn.com");
		postAuthors.add("구름");
		postContents.add("unchanged. It was popularised in the 1960s with the release");
		postLinks.add("https://line.me");

		boardGrid = findViewById(R.id.grid_board);
		boardGridAdapter = new BoardGridAdapter(this, cellStrings, cellCleared);
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
