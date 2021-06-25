package com.elkite.eattherainbow.features.shopping.search

import com.elkite.eattherainbow.components.shopping.shoppingItem.adapter.ShoppingItemCategorySpinnerAdapter
import com.elkite.eattherainbow.entities.category.Category
import com.elkite.eattherainbow.entities.ingredient.Ingredient
import com.elkite.eattherainbow.entities.shopping.ShoppingItem
import com.elkite.eattherainbow.extensions.hideKeyboard
import com.elkite.eattherainbow.extensions.showToastShort
import com.elkite.eattherainbow.managers.IngredientsManager
import com.elkite.eattherainbow.managers.ShoppingItemManager
import com.elkite.eattherainbow.tools.helpers.actions.BaseFragmentActions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchFragmentActions(val fragment: SearchFragment) : BaseFragmentActions() {

    fun prepopulatedb() {
        launch(Dispatchers.IO) {
            IngredientsManager.saveIngredient(Ingredient("Lait Amandes", Category.MILKS))
            IngredientsManager.saveIngredient(Ingredient("Flocons d'avoines", Category.CEREALS))
        }
    }

    fun createShoppingItem() {

        val productName = fragment.binding.product.text.toString()
        val productQuantity: Int = fragment.binding.quantity.text.toString().toIntOrNull() ?: 1

        val adapter = fragment.binding.categoriesSpinner.adapter as ShoppingItemCategorySpinnerAdapter
        val category: Category = adapter.items[fragment.binding.categoriesSpinner.selectedItemPosition]

        if (productName.isNotBlank()) {

            fragment.binding.product.clearFocus()
            fragment.binding.product.text.clear()
            fragment.binding.quantity.clearFocus()
            fragment.binding.quantity.text.clear()

            fragment.binding.addButton.requestFocus()

            fragment.hideKeyboard()

            launch(Dispatchers.IO) {
                ShoppingItemManager.saveItem(
                    ShoppingItem(
                        productName,
                        productQuantity,
                        category = category
                    )
                )

                withContext(Dispatchers.Main) {
                    fragment.context?.showToastShort(" Added $productName")
                }
            }
        }
    }
}