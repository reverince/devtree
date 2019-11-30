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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Main2Activity : AppCompatActivity() {
	lateinit var bottomNavigationView: BottomNavigationView
	private lateinit var inProgressBoardAdapter:InProgressBoardAdapter

	private val inProgressBoardViewList= arrayListOf(
		InProgressBoard("안드로이드 기초보드", "2019.11.29", "클리어한 과제 : 5개", "해야할 과제 : 5개")
	)

	private val introduceBoardList: ArrayList<IntroduceBoard> = arrayListOf(
		IntroduceBoard(R.drawable.android, "안드로이드 레이아웃", "레이아웃의 종류와 여러 레이아웃을 활용한 어플리케이션 만들기"),
		IntroduceBoard(R.drawable.android, "안드이드 4대 컴포넌트", "Activity, Service, BroadCast Receiver, Content Provider 안드로이드 4대 컴포넌트에 대한 공부"),
		IntroduceBoard(R.drawable.android, "사용자 이벤트 처리", "터치, 클릭, 스와이프, 드래그 등 여러 이벤트 처리에 대한 공부"),
		IntroduceBoard(R.drawable.apple, "XCode 다루기", "Swift를 통한 iOS 개발!"),
		IntroduceBoard(R.drawable.flutter, "플러터 기초", "강력한 모바일 크로스 플랫폼 플러터"),
		IntroduceBoard(R.drawable.git, "Git", "Git 없이 하는 프로젝트?")
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main2)

		setInProgressBoardAdapter()
		setIntroduceBoardAdapter()

		bottomNavigationView = findViewById(R.id.nav_bottom)
		bottomNavigationView.setOnNavigationItemSelectedListener { item ->
			when (item.itemId) {
				R.id.action_board -> {
					startActivity(Intent(this@Main2Activity, MyBoardActivity::class.java))
					overridePendingTransition(0, 0)
				}
				R.id.action_home -> {
				}
				R.id.action_profile -> {
					startActivity(Intent(this@Main2Activity, MyPageActivity::class.java))
					overridePendingTransition(0, 0)
				}
			}//finish();
			//Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
			true
		}


	}

	private fun setInProgressBoardAdapter() {
		// 진행중인 보드
		inProgressBoardAdapter = InProgressBoardAdapter(this, inProgressBoardViewList)

		inProgressRecyclerview.adapter = inProgressBoardAdapter

		val inProgressBoardManager = LinearLayoutManager(this)
		inProgressRecyclerview.layoutManager = inProgressBoardManager
//		inProgressRecyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
		inProgressRecyclerview.setHasFixedSize(true)

		inProgressBoardAdapter.setItemClickListener(object : InProgressBoardAdapter.ItemClickListener {
			override fun onClick(list: ArrayList<InProgressBoard>, view: View, position: Int) {
				Toast.makeText(this@Main2Activity, "${list[position]}", Toast.LENGTH_SHORT).show()
				val intent = Intent(this@Main2Activity, MyBoardActivity::class.java)
				startActivity(intent)
			}
		})
	}

	private fun setIntroduceBoardAdapter() {
		// 코스 소개

		val introduceBoardAdapter = IntroduceBoardAdapter(this, introduceBoardList)
		IntroduceBoardRecyclerview.adapter = introduceBoardAdapter

		val linearLayoutManager = LinearLayoutManager(this)
//		recyclerview.layoutManager = linearLayoutManager
		IntroduceBoardRecyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
		IntroduceBoardRecyclerview.setHasFixedSize(true)

		introduceBoardAdapter.setItemClickListener(object : IntroduceBoardAdapter.ItemClickListener {
			override fun onClick(list: ArrayList<IntroduceBoard>, view: View, position: Int) {
				Toast.makeText(this@Main2Activity, "${list[position]}", Toast.LENGTH_SHORT).show()
				val current : Date = Calendar.getInstance().time
				val date : String = SimpleDateFormat("yyyy.MM.dd",Locale.getDefault()).format(current)
				val clearTask = 0
				val todoTask = 9
				inProgressBoardViewList.add(InProgressBoard("${list[position].boardName}","$date","완료한 과제 : $clearTask", "해야할 과제 : $todoTask"))
				inProgressBoardAdapter.notifyDataSetChanged()
//				val intent = Intent(this@Main2Activity, BoardPreviewActivity::class.java)
//				startActivity(intent)
			}
		})

	}

}