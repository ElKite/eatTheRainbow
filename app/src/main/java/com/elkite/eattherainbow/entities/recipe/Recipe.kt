package com.elkite.eattherainbow.entities.recipe

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Recipe(
    val displayName: String
) {
    @PrimaryKey(autoGenerate = true)  var recipeId: Int = 0
}