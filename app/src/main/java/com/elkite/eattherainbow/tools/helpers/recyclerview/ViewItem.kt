package com.elkite.eattherainbow.tools.helpers.recyclerview

import androidx.annotation.LayoutRes
import androidx.databinding.BaseObservable

abstract class ViewItem(
    @LayoutRes open val layoutId: Int
) : BaseObservable(), Comparable<ViewItem> {

    abstract val data : ViewItemDatabinding
    abstract val actions : ViewItemAction

    override fun compareTo(other: ViewItem): Int {
        return other.data.compareTo(data)
    }
}
