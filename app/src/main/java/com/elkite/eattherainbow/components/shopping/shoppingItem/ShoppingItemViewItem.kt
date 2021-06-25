package com.elkite.eattherainbow.components.shopping.shoppingItem

import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItem

class ShoppingItemViewItem(
    override val data: ShoppingItemDatabinding,
    override val actions: ShoppingItemActions
): ViewItem(R.layout.view_shopping_item)