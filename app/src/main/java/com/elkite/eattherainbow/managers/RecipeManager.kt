package com.elkite.eattherainbow.managers

import androidx.lifecycle.LiveData
import com.elkite.eattherainbow.entities.recipe.Recipe
import com.elkite.eattherainbow.managers.database.DatabaseInstances

object RecipeManager {

    fun saveRecipe(item: Recipe) {
        DatabaseInstances.recipesDB.recipeItemDao().insertRecipeItem(item)
    }

    fun getAllItems() : LiveData<List<Recipe>> {
        return DatabaseInstances.recipesDB.recipeItemDao().getAllRecipeItems()
    }

    fun deleteItem(item: Recipe) {
        DatabaseInstances.recipesDB.recipeItemDao().deleteRecipeItem(item)
    }
}