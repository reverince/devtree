package io.github.reverince.devtree.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.reverince.devtree.InProgressBoard
import io.github.reverince.devtree.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
//	override fun onClick(position: Int) {
//		Toast.makeText(this,"토스트$position",Toast.LENGTH_SHORT).show()
//	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main2)
		val list = arrayListOf(
				InProgressBoard("안드로이드 기초보드","2019.11.29","클리어한 과제 : 5개","해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드","2019.11.29","클리어한 과제 : 5개","해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드","2019.11.29","클리어한 과제 : 5개","해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드","2019.11.29","클리어한 과제 : 5개","해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드","2019.11.29","클리어한 과제 : 5개","해야할 과제 : 5개"),
				InProgressBoard("안드로이드 기초보드","2019.11.29","클리어한 과제 : 5개","해야할 과제 : 5개")
		)
		val adapter = InProgressBoardAdapter(this, list)
		recyclerview.adapter = adapter

		val linearLayoutManager = LinearLayoutManager(this)
		recyclerview.layoutManager = linearLayoutManager
		recyclerview.setHasFixedSize(true)

		adapter.setItemClickListener(object : InProgressBoardAdapter.ItemClickListener {
			override fun onClick(list: ArrayList<InProgressBoard>, view: View, position: Int) {
				Toast.makeText(this@Main2Activity,"${list.get(position)}",Toast.LENGTH_SHORT).show()
			}
		})


	}

}