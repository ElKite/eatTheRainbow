package com.elkite.eattherainbow.managers

import androidx.lifecycle.LiveData
import com.elkite.eattherainbow.entities.shopping.ShoppingItem
import com.elkite.eattherainbow.managers.database.DatabaseInstances

object ShoppingItemManager {

    fun saveItem(item: ShoppingItem) {
        DatabaseInstances.shoppingDB.shoppingItemDao().insertShoppingItem(item)
    }

    fun getItem(id: Int) {

    }

    fun saveItems(items: List<ShoppingItem>) {

    }

    fun updateItem(item: ShoppingItem) {
        DatabaseInstances.shoppingDB.shoppingItemDao().updateItem(item)
    }

    fun getAllItems(): LiveData<List<ShoppingItem>> {
        return DatabaseInstances.shoppingDB.shoppingItemDao().getAllShoppingItem()
    }

    fun getAllItemsByAddedToCart(addedToCart: Boolean): LiveData<List<ShoppingItem>> {
        return if (addedToCart) DatabaseInstances.shoppingDB.shoppingItemDao().getAddedShoppingItem()
        else DatabaseInstances.shoppingDB.shoppingItemDao().getNotAddedShoppingItem()
    }

    fun deleteItem(item: ShoppingItem) {
        DatabaseInstances.shoppingDB.shoppingItemDao().deleteShoppingItem(item)
    }

    fun deleteAllCartItems() {
        DatabaseInstances.shoppingDB.shoppingItemDao().deleteAllCartItems()
    }

    fun uncheckAllCartItems() {
        DatabaseInstances.shoppingDB.shoppingItemDao().uncheckAllCartItems()
    }
}