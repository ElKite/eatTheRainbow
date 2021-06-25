package com.elkite.eattherainbow.components.shopping.shoppingItem

import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemDatabinding

class ShoppingItemDatabinding(
    val name: String,
    val quantity: Int,
    val category: Int,
    val addedToCart: Boolean
): ViewItemDatabinding() {

    val showQuantity: Boolean = quantity > 1

    override fun compareTo(other: ViewItemDatabinding): Int {
        return when {
            this.name != (other as ShoppingItemDatabinding).name -> 1
            this.addedToCart != other.addedToCart -> 1
            this.quantity != other.quantity -> 1
            this.category != other.category -> 1
            else -> { 0 }
        }
    }
}