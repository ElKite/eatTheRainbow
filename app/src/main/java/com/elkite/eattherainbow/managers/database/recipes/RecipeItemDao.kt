package com.elkite.eattherainbow.managers.database.recipes

import androidx.lifecycle.LiveData
import androidx.room.*
import com.elkite.eattherainbow.entities.recipe.Recipe
import com.elkite.eattherainbow.entities.recipe.RecipeWithIngredients

@Dao
interface RecipeItemDao {
    @Query("SELECT * FROM recipe")
    fun getAllRecipeItems(): LiveData<List<Recipe>>

    @Insert
    fun insertRecipeItem(item: Recipe)

    @Delete
    fun deleteRecipeItem(item: Recipe)

    @Transaction
    @Query("SELECT * FROM recipe")
    fun getPlaylistsWithSongs(): List<RecipeWithIngredients>
}