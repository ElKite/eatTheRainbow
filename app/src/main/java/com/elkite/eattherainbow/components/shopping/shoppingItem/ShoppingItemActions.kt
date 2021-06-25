package com.elkite.eattherainbow.components.shopping.shoppingItem

import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemAction

class ShoppingItemActions(
    onClick: () -> Unit,
    val onSwipeAction: () -> Unit
) : ViewItemAction(onClick) {

    fun onSwipe() {
        onSwipeAction()
    }
}