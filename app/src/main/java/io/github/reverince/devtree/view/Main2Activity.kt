package io.github.reverince.devtree.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.reverince.devtree.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main2)

		setInProgressBoardAdapter()
		setIntroduceBoardAdapter()



	}
	private fun setInProgressBoardAdapter(){
		// 진행중인 보드
		val inProgressBoardViewList = arrayListOf(
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