package com.elkite.eattherainbow.features.recipes.details

import android.content.Context
import android.widget.Toast
import com.elkite.eattherainbow.tools.helpers.actions.BaseFragmentActions

class RecipesDetailsActionsFragment : BaseFragmentActions() {

    fun showAddItemAlert(context: Context) {
        Toast.makeText(context, "Add item", Toast.LENGTH_SHORT).show()
    }
}
