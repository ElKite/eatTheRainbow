package com.elkite.eattherainbow.entities.ingredient

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elkite.eattherainbow.entities.category.Category

@Entity
class Ingredient(
    val displayName: String,
    var category: Category
) {
    @PrimaryKey(autoGenerate = true)  var ingredientId: Int = 0
}