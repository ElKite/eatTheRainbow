package com.elkite.eattherainbow.features.shopping.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.elkite.eattherainbow.components.category.CategoryViewItem
import com.elkite.eattherainbow.components.category.CategoryViewItemDatabinding
import com.elkite.eattherainbow.components.shopping.shoppingItem.adapter.ShoppingItemCategorySpinnerAdapter
import com.elkite.eattherainbow.databinding.FragmentSearchBinding
import com.elkite.eattherainbow.entities.category.Category
import com.elkite.eattherainbow.tools.helpers.recyclerview.ViewItemAction

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.actions = SearchFragmentActions(this)
        binding.data = SearchFragmentDatabinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actions?.prepopulatedb() //TODO REMOVE

        initCategoriesViewItem()
        initCategoriesSpinner()
    }

    private fun initCategoriesViewItem() {
        val category: Array<Category> = Category.values()
        binding.data?.categories = category.map {
            CategoryViewItem(
                CategoryViewItemDatabinding(it),
                ViewItemAction {
                    findNavController().navigate(
                        SearchFragmentDirections.actionNavigationSearchToSearchChild(it)
                    )
                }
            )
        }
    }

    private fun initCategoriesSpinner() {
        binding.categoriesSpinner.adapter = ShoppingItemCategorySpinnerAdapter(
            listOf(
                Category.UNDEFINED,
                Category.VEGETABLES,
                Category.FRUITS,
                Category.MEAT
            ), requireContext()
        )
        binding.categoriesSpinner.setSelection(0)
    }
}