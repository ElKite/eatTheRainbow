package com.elkite.eattherainbow.components.ingredient

import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemDatabinding

class IngredientDataBinding(
    val name: String
): ViewItemDatabinding() {

    override fun compareTo(other: ViewItemDatabinding): Int {

        return if (this.name != (other as IngredientDataBinding).name)
            1
        else {
            0
        }
    }
}