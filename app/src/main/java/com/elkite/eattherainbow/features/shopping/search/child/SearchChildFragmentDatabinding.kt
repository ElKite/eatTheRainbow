package com.elkite.eattherainbow.features.shopping.search.child

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.elkite.eattherainbow.BR
import com.elkite.eattherainbow.components.shopping.search.SearchIngredientViewItem

class SearchChildFragmentDatabinding: BaseObservable() {

    @get:Bindable
    var searchShoppingItems : List<SearchIngredientViewItem> = listOf()
   set(value) {
       field = value
       notifyPropertyChanged(BR.searchShoppingItems)
   }
}