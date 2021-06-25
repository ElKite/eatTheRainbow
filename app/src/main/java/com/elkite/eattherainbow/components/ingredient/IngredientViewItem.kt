package com.elkite.eattherainbow.components.ingredient

import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemAction
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItem

class IngredientViewItem(
    override val data: IngredientDataBinding,
    override val actions: ViewItemAction
): ViewItem(R.layout.view_ingredient_item)