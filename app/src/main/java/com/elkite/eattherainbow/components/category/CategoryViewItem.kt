package com.elkite.eattherainbow.components.category

import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItem
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemAction

class CategoryViewItem(
    override val data: CategoryViewItemDatabinding,
    override val actions: ViewItemAction
) : ViewItem(R.layout.view_category_item)