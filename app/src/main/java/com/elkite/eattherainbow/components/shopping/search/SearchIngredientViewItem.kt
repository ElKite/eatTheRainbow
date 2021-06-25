package com.elkite.eattherainbow.components.shopping.search

import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItem
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemAction

class SearchIngredientViewItem(
    override val data: SearchIngredientDatabinding,
    override val actions: ViewItemAction
): ViewItem(R.layout.view_search_shopping_item)