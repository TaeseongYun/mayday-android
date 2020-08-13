package com.project.mayday.component

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(
    private val density: Float, private val pageId: String, private val dataCnt: Int?
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (dataCnt == null) return

        val position = parent.getChildAdapterPosition(view)

        when (pageId) {
            "/*임의의 키*/" -> {
                outRect.bottom = (10 * density).toInt()
                if (position == dataCnt - 1) {
                    outRect.bottom = (15 * density).toInt()
                }
            }
        }
    }
}