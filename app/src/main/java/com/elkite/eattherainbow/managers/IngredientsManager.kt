package com.elkite.eattherainbow.managers

import androidx.lifecycle.LiveData
import com.elkite.eattherainbow.entities.ingredient.Ingredient
import com.elkite.eattherainbow.managers.database.DatabaseInstances

object IngredientsManager {

    fun saveIngredient(item: Ingredient) {
        DatabaseInstances.recipesDB.ingredientItemDao().insertIngredient(item)
    }

    fun deleteIngredient(item: Ingredient) {
        DatabaseInstances.recipesDB.ingredientItemDao().deleteIngredient(item)
    }

    fun getAllIngredientsFromCategory(category: String): LiveData<List<Ingredient>> =
        DatabaseInstances.recipesDB.ingredientItemDao().getAllIngredientsFromCategory(category)

    fun getAllIngredients(): LiveData<List<Ingredient>> =
        DatabaseInstances.recipesDB.ingredientItemDao().getAllIngredients()
}