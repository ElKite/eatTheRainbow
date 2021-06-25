package com.elkite.eattherainbow.features.shopping.search

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.elkite.eattherainbow.BR
import com.elkite.eattherainbow.components.category.CategoryViewItem

class SearchFragmentDatabinding: BaseObservable() {

    @get:Bindable
    var categories: List<CategoryViewItem> = listOf()
    set(value) {
        field = value
        notifyPropertyChanged(BR.categories)
    }
}