package com.elkite.eattherainbow.tools.helpers.recyclerview

import androidx.databinding.BaseObservable

open class ViewItemDatabinding: BaseObservable(), Comparable<ViewItemDatabinding> {
    override fun compareTo(other: ViewItemDatabinding): Int {
        return 1
    }
}