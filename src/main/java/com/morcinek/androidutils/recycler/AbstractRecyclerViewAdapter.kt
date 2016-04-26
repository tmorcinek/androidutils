package com.morcinek.androidutils.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import java.util.*

/**
 * Copyright 2015 Tomasz Morcinek. All rights reserved.
 */
abstract class AbstractRecyclerViewAdapter<T, H : RecyclerView.ViewHolder>(protected var context: Context) : RecyclerView.Adapter<H>() {

    protected val items = ArrayList<T>()

    var itemClickListener: OnItemClickListener<T>? = null

    inline fun setItemClickListener(crossinline function: (T) -> Unit) {
        itemClickListener = object : OnItemClickListener<T> {
            override fun onItemClicked(item: T) {
                function.invoke(item)
            }
        }
    }

    protected fun getItem(position: Int): T {
        return items[position]
    }

    fun setListAnimated(list: List<T>) {
        items.clear()
        notifyDataSetChanged()
        items.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }

    fun setList(list: List<T>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    protected fun initializeOnClickListener(holder: H, item: T) {
        holder.itemView.setOnClickListener { itemClickListener?.onItemClicked(item) }
    }

    interface OnItemClickListener<T> {

        fun onItemClicked(item: T)
    }
}
