package com.elkite.eattherainbow.managers.database.recipes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elkite.eattherainbow.entities.category.CategoryConverter
import com.elkite.eattherainbow.entities.ingredient.Ingredient
import com.elkite.eattherainbow.entities.recipe.Recipe
import com.elkite.eattherainbow.entities.recipe.RecipeIngredientCrossRef


@Database(entities = [Recipe::class, RecipeIngredientCrossRef::class, Ingredient::class], version = 1, exportSchema = false)
@TypeConverters(CategoryConverter::class)
abstract class RecipesDataBase : RoomDatabase() {
    abstract fun recipeItemDao(): RecipeItemDao
    abstract fun ingredientItemDao(): IngredientItemDao

    companion object {
        fun createRecipesDatabase(context: Context): RecipesDataBase {
            return Room.databaseBuilder(
                context,
                RecipesDataBase::class.java,
                "recipes_db"
            ).build()
        }
    }
}