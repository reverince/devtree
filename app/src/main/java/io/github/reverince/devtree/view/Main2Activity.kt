package io.github.reverince.devtree.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.reverince.devtree.R
import io.github.reverince.devtree.data.InProgressBoard
import io.github.reverince.devtree.data.IntroduceBoard
import io.github.reverince.devtree.rcv.InProgressBoardAdapter
import io.github.reverince.devtree.rcv.IntroduceBoardAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
	lateinit var bottomNavigationView: BottomNavigationView
	lateinit var boardPreviewBtn: Button

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main2)

		setInProgressBoardAdapter()
		setIntroduceBoardAdapter()

      bottomNavigationView = findViewById(R.id.nav_bottom)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
			when (item.itemId) {
				R.id.action_board -> {
					val intent = Intent(this@Main2Activity, MyBoardActivity::class.java)
					startActivity(intent)
					overridePendingTransition(0, 0)
					finish()
				}
				R.id.action_home -> {}
				R.id.action_profile -> {}
			}//finish();
			//Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
			true
		}
		       boardPreviewBtn = findViewById(R.id.btn_board_preview)
        boardPreviewBtn.setOnClickListener {
			val intent = Intent(this@Main2Activity, BoardPreviewActivity::class.java)
			startActivity(intent)
		}

	}
	private fun setInProgressBoardAdapter(){
		// 진행중인 보드
		val inProgressBoardViewList = arrayListOf(
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개")
		)
		val inProgressBoardAdapter = InProgressBoardAdapter(this, inProgressBoardViewList)
		inProgressRecyclerview.adapter = inProgressBoardAdapter

		val inProgressBoardManager = LinearLayoutManager(this)
		inProgressRecyclerview.layoutManager = inProgressBoardManager
//		inProgressRecyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
		inProgressRecyclerview.setHasFixedSize(true)

		inProgressBoardAdapter.setItemClickListener(object : InProgressBoardAdapter.ItemClickListener {
			override fun onClick(list: ArrayList<InProgressBoard>, view: View, position: Int) {
				Toast.makeText(this@Main2Activity, "${list[position]}", Toast.LENGTH_SHORT).show()
			}
		})
	}

	private fun setIntroduceBoardAdapter(){
		// 코스 소개
		val introduceBoardList: ArrayList<IntroduceBoard> = arrayListOf(
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "안드로이드 레이아웃", "여러 레이아웃을 다룸"),
				IntroduceBoard(R.drawable.ic_launcher_background, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_launcher_foreground, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa"),
				IntroduceBoard(R.drawable.ic_adb_black_24dp, "aa", "aa")
		)
		val introduceBoardAdapter = IntroduceBoardAdapter(this, introduceBoardList)
		IntroduceBoardRecyclerview.adapter = introduceBoardAdapter

		val linearLayoutManager = LinearLayoutManager(this)
//		recyclerview.layoutManager = linearLayoutManager
		IntroduceBoardRecyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
		IntroduceBoardRecyclerview.setHasFixedSize(true)

		introduceBoardAdapter.setItemClickListener(object : IntroduceBoardAdapter.ItemClickListener {
			override fun onClick(list: ArrayList<IntroduceBoard>, view: View, position: Int) {
				Toast.makeText(this@Main2Activity, "${list[position]}", Toast.LENGTH_SHORT).show()
			}
		})

	}

}