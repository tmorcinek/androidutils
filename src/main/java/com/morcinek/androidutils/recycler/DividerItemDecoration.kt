package com.morcinek.androidutils.recycler

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.morcinek.androidutils.R


class DividerItemDecoration(context: Context, dividerDrawableId: Int = R.drawable.default_divider,
                            var showFirst: Boolean = true, var showLast: Boolean = true) : RecyclerView.ItemDecoration() {

    private val divider: Drawable?
    private val dividerHeight: Int
    private val dividerWidth: Int

    init {
        divider = context.resources.getDrawable(dividerDrawableId)
        dividerHeight = if (divider == null) 0 else divider.intrinsicHeight
        dividerWidth = if (divider == null) 0 else divider.intrinsicWidth
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State?) {
        if (divider == null) {
            super.getItemOffsets(outRect, view, parent, state)
            return
        }

        val position = (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        val firstItem = position == 0
        val lastItem = position == parent.adapter.itemCount - 1
        val dividerBefore = showFirst || !firstItem
        val dividerAfter = showLast && lastItem

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            outRect.top = if (dividerBefore) dividerHeight else 0
            outRect.bottom = if (dividerAfter) dividerHeight else 0
        } else {
            outRect.left = if (dividerBefore) dividerWidth else 0
            outRect.right = if (dividerAfter) dividerWidth else 0
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        if (divider == null) {
            super.onDraw(c, parent, state)
            return
        }

        var left = 0
        var right = 0
        var top = 0
        var bottom = 0

        val orientation = getOrientation(parent)
        val childCount = parent.childCount

        val adapter = parent.adapter
        val adapterCount = if (adapter != null) adapter.itemCount else 0

        val vertical = orientation == LinearLayoutManager.VERTICAL
        val size: Int
        if (vertical) {
            size = dividerHeight
            left = parent.paddingLeft
            right = parent.width - parent.paddingRight
        } else {
            size = dividerWidth
            top = parent.paddingTop
            bottom = parent.height - parent.paddingBottom
        }

        for (i in 0..childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val position = params.viewLayoutPosition
            if (position == 0 && !showFirst) {
                continue
            }
            if (vertical) {
                top = child.top - params.topMargin - size
                bottom = top + size
            } else {
                left = child.left - params.leftMargin - size
                right = left + size
            }
            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }

        if (showLast && childCount > 0) {
            val child = parent.getChildAt(childCount - 1)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val position = params.viewLayoutPosition
            if (position == adapterCount - 1) {
                if (vertical) {
                    top = child.bottom + params.bottomMargin
                    bottom = top + size
                } else {
                    left = child.right + params.rightMargin
                    right = left + size
                }
                divider.setBounds(left, top, right, bottom)
                divider.draw(c)
            }
        }
    }

    private fun getOrientation(parent: RecyclerView): Int {
        val lm = parent.layoutManager
        if (lm is LinearLayoutManager) {
            return lm.orientation
        } else {
            throw IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager")
        }
    }
}