package com.vk.education.rectangles

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val text: TextView = view.findViewById(R.id.text_1)
    private val image: ImageView = view.findViewById(R.id.image_view)

    fun bind(number: Int) {
        text.text = "$number"
        image.setBackgroundColor(
            ContextCompat.getColor(
                itemView.context,
                if (number % 2 == 0) R.color.red else R.color.blue
            )
        )
    }
}