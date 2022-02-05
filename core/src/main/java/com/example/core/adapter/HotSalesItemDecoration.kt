package com.example.core.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HotSalesItemDecoration(
    private val divider: Int,
    private val margin: Int
) : RecyclerView.ItemDecoration() {

    private fun RecyclerView.Adapter<*>.isPrevView(
        currentPosition: Int
    ): Boolean {
        return currentPosition != 0
    }

    private fun RecyclerView.Adapter<*>.isNextView(
        currentPosition: Int
    ): Boolean {
        return currentPosition != itemCount - 1
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val adapter = parent.adapter ?: return
        val position = parent.getChildAdapterPosition(view)

        val isPrevView = adapter.isPrevView(position)
        val isNextView = adapter.isNextView(position)

        with(outRect) {
            left = if (isPrevView) divider else margin
            right = if (isNextView) divider else margin
        }
    }
}