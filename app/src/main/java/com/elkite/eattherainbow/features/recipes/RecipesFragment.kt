package com.elkite.eattherainbow.features.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.elkite.eattherainbow.components.recipeItem.RecipeComposable
import com.elkite.eattherainbow.entities.recipe.Recipe
import com.elkite.eattherainbow.managers.RecipeManager

class RecipesFragment : Fragment() {

    lateinit var actions: RecipesFragmentActions

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        actions = RecipesFragmentActions()

        return ComposeView(requireContext()).apply {
            setContent {
                RecipesFragmentContent()
            }
        }
    }

    @Composable
    fun RecipesFragmentContent() {
        val recipes: List<Recipe>? = RecipeManager.getAllItems().observeAsState().value

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick =  {
                    actions.showAddItemAlert(requireContext())
                }) {
                    Icon(Icons.Filled.Add,"")
                }
            }
        ) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(
                    items = recipes ?: listOf(),
                    itemContent = {
                        RecipeComposable.RecipeCard(it)
                    })
            }
        }



    }
}
