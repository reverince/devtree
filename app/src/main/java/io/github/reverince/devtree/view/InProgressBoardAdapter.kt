package io.github.reverince.devtree.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.reverince.devtree.InProgressBoard
import io.github.reverince.devtree.R


class InProgressBoardAdapter(val context: Context, val list:ArrayList<InProgressBoard>) : RecyclerView.Adapter<InProgressBoardAdapter.Holder>(){
	interface ItemClickListener{
		fun onClick(list: ArrayList<InProgressBoard>,view:View, position: Int)
	}

	private lateinit var itemClickListener: ItemClickListener

	fun setItemClickListener(itemClickListener: ItemClickListener){
		this.itemClickListener = itemClickListener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val view = LayoutInflater.from(context).inflate(R.layout.inprogress_item, parent, false)
		return Holder(view)
	}

	override fun getItemCount(): Int {
		return list.size
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(list[position], position)
	}

	inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//		var view = hol
		val boardNameTextView: TextView = itemView.findViewById(R.id.boardNameTextVIew)
		val startDayTextView:TextView = itemView.findViewById(R.id.startDayTextView)
		val clearTaskTextView:TextView = itemView.findViewById(R.id.clearBoardTextVIew)
		val todoTaskTextView:TextView = itemView.findViewById(R.id.todoTaskTextView)

		fun bind (inProgressBoard: InProgressBoard, position: Int) {
			boardNameTextView.text = inProgressBoard.boardName
			startDayTextView.text = inProgressBoard.startDay
			clearTaskTextView.text = inProgressBoard.clearTask
			todoTaskTextView.text = inProgressBoard.todoTask

			itemView.setOnClickListener {
				itemClickListener.onClick(list, it, position)
			}
		}
	}
}