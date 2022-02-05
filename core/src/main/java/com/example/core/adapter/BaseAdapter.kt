package com.example.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.listener.BaseItemListener

class BaseAdapter<T, L : BaseItemListener>(
    private val layoutId: Int,
    private val listener: L,
    private val bind: ((View, data: T, listener: L) -> Unit)
) : RecyclerView.Adapter<BaseAdapter<T, L>.BaseViewHolder>() {

    private var data: List<T> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val viewHolder =
            BaseViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<T>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class BaseViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: T, listener: L) {
            bind(view, data, listener)
        }
    }
}