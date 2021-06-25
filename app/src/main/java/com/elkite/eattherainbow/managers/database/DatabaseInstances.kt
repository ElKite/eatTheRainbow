package com.elkite.eattherainbow.managers.database

import android.content.Context
import com.elkite.eattherainbow.managers.database.recipes.RecipesDataBase
import com.elkite.eattherainbow.managers.database.shopping.ShoppingDataBase

object DatabaseInstances {
    lateinit var shoppingDB: ShoppingDataBase
    lateinit var recipesDB: RecipesDataBase

    fun initDatabases(context: Context) {
        shoppingDB = ShoppingDataBase.createShoppingDatabase(context)
        recipesDB = RecipesDataBase.createRecipesDatabase(context)
    }
}