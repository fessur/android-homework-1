package com.vk.education.rectangles

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ITEMS_KEY = "items"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemsAdapter
    private lateinit var items: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = savedInstanceState?.getIntegerArrayList(ITEMS_KEY) ?: getInitialItems()
        adapter = ItemsAdapter(items)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            addItem(items.size + 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(ITEMS_KEY, items)
    }

    private fun getInitialItems() =
        resources.getIntArray(R.array.initial_items).toCollection(ArrayList())

    private fun addItem(item: Int) {
        val extent = recyclerView.computeVerticalScrollExtent()
        val range = recyclerView.computeVerticalScrollRange()
        val offset = recyclerView.computeVerticalScrollOffset()

        items.add(item)
        adapter.notifyItemInserted(items.lastIndex)

        if (extent + offset == range) {
            recyclerView.scrollToPosition(items.lastIndex)
        }
    }
}