package com.elkite.eattherainbow.components.shopping.search

import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemDatabinding

class SearchIngredientDatabinding(val name: String) : ViewItemDatabinding() {

    override fun compareTo(other: ViewItemDatabinding): Int {
        return when {
            this.name != (other as SearchIngredientDatabinding).name -> 1
            else -> { 0 }
        }
    }
}