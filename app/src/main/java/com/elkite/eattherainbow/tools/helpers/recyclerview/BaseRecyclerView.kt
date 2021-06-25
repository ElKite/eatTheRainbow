package com.elkite.eattherainbow.tools.helpers.recyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class BaseRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun BaseRecyclerView.bindItems(items: List<ViewItem>?) {
            items?.let {
                genericAdapter.setItemList(items)
            }
        }
    }

    internal val genericAdapter = ViewTypeAdapter()

    init {
        super.setAdapter(genericAdapter)
    }


}
