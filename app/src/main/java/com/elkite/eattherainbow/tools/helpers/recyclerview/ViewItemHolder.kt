package com.elkite.eattherainbow.tools.helpers.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.elkite.eattherainbow.BR

class ViewItemHolder<Model: ViewItem>(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: Model) {
        binding.setVariable(BR.viewItem, item)
        binding.executePendingBindings()
    }
}