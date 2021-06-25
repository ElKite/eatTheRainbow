package com.elkite.eattherainbow.components.shopping.shoppingItem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.entities.category.Category
import com.google.android.material.textview.MaterialTextView

class ShoppingItemCategorySpinnerAdapter(val items: List<Category>, val context: Context) : BaseAdapter() {
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItem(pos: Int): Category {
        return items[pos]
    }

    override fun getItemId(pos: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    override fun getView(pos: Int, v: View?, viewGroup: ViewGroup?): View {
        val view = inflater.inflate(R.layout.spinner_shopping_category, viewGroup, false)

        val categoryColor = view.findViewById<View>(R.id.categoryColor)
        val categoryName = view.findViewById<MaterialTextView>(R.id.categoryName)
        categoryColor.setBackgroundColor(context.getColor(items[pos].colorId))
        categoryName.text = context.getString(items[pos].nameId)
        return view
    }
}
