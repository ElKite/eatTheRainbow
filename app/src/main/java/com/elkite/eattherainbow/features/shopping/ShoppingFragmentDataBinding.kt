package com.elkite.eattherainbow.features.shopping

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.elkite.eattherainbow.BR
import com.elkite.eattherainbow.components.shopping.shoppingItem.ShoppingItemViewItem

class ShoppingFragmentDataBinding : BaseObservable() {

    @get:Bindable
    var shoppingItems = listOf<ShoppingItemViewItem>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.shoppingItems)
    }

    @get:Bindable
    var cartItems = listOf<ShoppingItemViewItem>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.cartItems)
    }
}