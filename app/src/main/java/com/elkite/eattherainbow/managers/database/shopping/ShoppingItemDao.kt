package com.elkite.eattherainbow.managers.database.shopping

import androidx.lifecycle.LiveData
import androidx.room.*
import com.elkite.eattherainbow.entities.shopping.ShoppingItem

@Dao
interface ShoppingItemDao {
    @Query("SELECT * FROM shoppingitem")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

    @Query("SELECT * FROM shoppingitem WHERE addedToCart LIKE 1")
    fun getAddedShoppingItem(): LiveData<List<ShoppingItem>>

    @Query("SELECT * FROM shoppingitem WHERE addedToCart LIKE 0")
    fun getNotAddedShoppingItem(): LiveData<List<ShoppingItem>>

    @Insert
    fun insertShoppingItem(item: ShoppingItem)

    @Insert
    fun insertShoppingItems(items: List<ShoppingItem>)

    @Delete
    fun deleteShoppingItem(item: ShoppingItem)

    @Query("DELETE FROM shoppingitem WHERE addedToCart LIKE 1")
    fun deleteAllCartItems()

    @Update
    fun updateItem(item: ShoppingItem)

    @Query("UPDATE shoppingitem SET addedToCart= 0 WHERE addedToCart = 1")
    fun uncheckAllCartItems()

}