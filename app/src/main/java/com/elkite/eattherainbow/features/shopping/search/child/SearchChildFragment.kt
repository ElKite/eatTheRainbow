package com.elkite.eattherainbow.features.shopping.search.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.elkite.eattherainbow.MainActivity
import com.elkite.eattherainbow.components.shopping.search.SearchIngredientDatabinding
import com.elkite.eattherainbow.components.shopping.search.SearchIngredientViewItem
import com.elkite.eattherainbow.databinding.FragmentSearchChildBinding
import com.elkite.eattherainbow.entities.ingredient.Ingredient
import com.elkite.eattherainbow.managers.IngredientsManager
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemAction
import timber.log.Timber

class SearchChildFragment : Fragment() {

    lateinit var binding: FragmentSearchChildBinding
    val args: SearchChildFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchChildBinding.inflate(inflater, container, false)
        binding.actions = SearchChildFragmentActions()
        binding.data = SearchChildFragmentDatabinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? MainActivity)?.setTitle(getString(args.category.nameId))

        IngredientsManager.getAllIngredientsFromCategory(args.category.name).observe(viewLifecycleOwner) {
            it.map {
                Timber.e(it.displayName)
            }
            handleIngredients(it)
        }

    }

    private fun handleIngredients(ingredients: List<Ingredient>) {
        binding.data?.searchShoppingItems = ingredients.map {
            SearchIngredientViewItem(
                SearchIngredientDatabinding(it.displayName),
                ViewItemAction {
                   binding.actions?.clickIngredient()
                }
            )
        }
    }
}