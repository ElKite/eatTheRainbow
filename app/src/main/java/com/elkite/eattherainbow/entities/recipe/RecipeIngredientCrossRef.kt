package com.elkite.eattherainbow.entities.recipe

import androidx.room.Entity

@Entity(primaryKeys = ["recipeId", "ingredientId"])
data class RecipeIngredientCrossRef(
    val recipeId: Int,
    val ingredientId: Int
)