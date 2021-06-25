package com.elkite.eattherainbow.tools.helpers.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

open class ViewTypeAdapter: RecyclerView.Adapter<ViewItemHolder<ViewItem>>()  {
    private var itemList: MutableList<ViewItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder<ViewItem> {
        val binding: ViewDataBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context), viewType,
                parent, false)
        return ViewItemHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewItemHolder<ViewItem>, position: Int) {
        holder.bindItem(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(itemList[position])
    }

    fun getLayoutId(model: ViewItem): Int {
        return model.layoutId
    }

    fun setItemList(list: List<ViewItem>) {
        val diffCallback = DiffCallback<ViewItem>()
        diffCallback.setLists(this.itemList, list)
        val result = DiffUtil.calculateDiff(diffCallback)
        this.itemList.clear()
        this.itemList.addAll(list)
        result.dispatchUpdatesTo(this)
    }

    fun getItemList(): List<ViewItem> {
        return itemList
    }
}

class DiffCallback<T: Comparable<T>>: DiffUtil.Callback() {
    private var oldList: List<T> = emptyList()
    private var newList: List<T> = emptyList()

    fun setLists(oldList: List<T>, newList: List<T>) {
        this.oldList = oldList
        this.newList = newList
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition].compareTo(newList[newItemPosition]) == 0

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = true
}
