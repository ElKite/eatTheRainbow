package com.elkite.eattherainbow.managers.database.shopping

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elkite.eattherainbow.entities.category.CategoryConverter
import com.elkite.eattherainbow.entities.shopping.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1, exportSchema = false)
@TypeConverters(CategoryConverter::class)
abstract class ShoppingDataBase : RoomDatabase() {
    abstract fun shoppingItemDao(): ShoppingItemDao


    companion object {
        fun createShoppingDatabase(context: Context): ShoppingDataBase {
            return Room.databaseBuilder(
                context,
                ShoppingDataBase::class.java,
                "shopping_db"
            ).build()
        }
    }
}