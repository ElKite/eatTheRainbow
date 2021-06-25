package com.elkite.eattherainbow.entities.recipe

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.elkite.eattherainbow.entities.ingredient.Ingredient

data class RecipeWithIngredients(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "ingredientId",
        associateBy = Junction(RecipeIngredientCrossRef::class)
    )
    val ingredients: List<Ingredient>
)