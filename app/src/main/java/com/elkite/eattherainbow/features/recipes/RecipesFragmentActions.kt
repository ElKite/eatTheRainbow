package com.elkite.eattherainbow.features.recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.entities.recipe.Recipe
import com.elkite.eattherainbow.managers.RecipeManager
import com.elkite.eattherainbow.tools.helpers.actions.BaseFragmentActions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipesFragmentActions : BaseFragmentActions() {

    fun showAddItemAlert(context: Context) {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)

        val view: View = inflater.inflate(R.layout.alert_create_shopping_item, null)
        val product = view.findViewById<EditText>(R.id.alert_product)
        val quantity = view.findViewById<EditText>(R.id.alert_quantity)

        val alert = builder
            .setView(view)
            .setTitle(R.string.alert_add_item_title)
            .setCancelable(true)
            .setPositiveButton(R.string.common_add) { _, _ ->

                val productName = product.text.toString()
                val productQuantity: Short = quantity.text.toString().toShortOrNull() ?: 1

                if (productName.isNotBlank())
                    launch(Dispatchers.IO) {
                        RecipeManager.saveRecipe(
                            Recipe(product.text.toString())
                        )
                    }
            }
            .setNegativeButton(R.string.common_cancel) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()
        alert.show()
    }

    fun deleteItem(item: Recipe) {
        launch(Dispatchers.IO) {
            RecipeManager.deleteItem(item)
        }
    }
}