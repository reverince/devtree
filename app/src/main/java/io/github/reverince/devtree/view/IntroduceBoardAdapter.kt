package io.github.reverince.devtree.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.reverince.devtree.R

class IntroduceBoardAdapter(val context: Context, val list: ArrayList<IntroduceBoard>) : RecyclerView.Adapter<IntroduceBoardAdapter.Holder>() {

	interface ItemClickListener {
		fun onClick(list: ArrayList<IntroduceBoard>, view: View, position: Int)
	}

	private lateinit var itemClickListener: ItemClickListener

	fun setItemClickListener(itemClickListener: ItemClickListener) {
		this.itemClickListener = itemClickListener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val view = LayoutInflater.from(context).inflate(R.layout.introduce_item, parent, false)
		return Holder(view)
	}

	override fun getItemCount(): Int {
		return list.size
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(list[position], position, context)
	}


	inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val imageView: ImageView = itemView.findViewById(R.id.imageView)
		val boardNameTextView: TextView = itemView.findViewById(R.id.boardNameTextVIew)
		val boardDescription: TextView = itemView.findViewById(R.id.boardDescriptionTextView)

		fun bind(introduceBoard: IntroduceBoard, position: Int, context: Context) {
			imageView.setImageResource(introduceBoard.image)
			boardNameTextView.text = introduceBoard.boardName
			boardDescription.text = introduceBoard.boardDescription

			itemView.setOnClickListener {
				itemClickListener.onClick(list, it, position)
			}
		}
	}
}