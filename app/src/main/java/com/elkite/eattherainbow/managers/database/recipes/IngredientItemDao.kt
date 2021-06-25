package com.elkite.eattherainbow.managers.database.recipes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.elkite.eattherainbow.entities.ingredient.Ingredient

@Dao
interface IngredientItemDao {
    @Query("SELECT * FROM ingredient")
    fun getAllIngredients(): LiveData<List<Ingredient>>

    @Query("SELECT * FROM ingredient WHERE :categoryParam LIKE category")
    fun getAllIngredientsFromCategory(categoryParam: String): LiveData<List<Ingredient>>

    @Insert
    fun insertIngredient(item: Ingredient)

    @Insert
    fun insertIngredients(items: List<Ingredient>)

    @Delete
    fun deleteIngredient(item: Ingredient)
}