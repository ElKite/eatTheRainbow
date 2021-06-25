package com.elkite.eattherainbow.features.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.elkite.eattherainbow.components.shopping.shoppingItem.ShoppingItemActions
import com.elkite.eattherainbow.components.shopping.shoppingItem.ShoppingItemDatabinding
import com.elkite.eattherainbow.components.shopping.shoppingItem.ShoppingItemViewItem
import com.elkite.eattherainbow.databinding.FragmentShoppingBinding
import com.elkite.eattherainbow.entities.shopping.ShoppingItem
import com.elkite.eattherainbow.entities.shopping.sortByCategory
import com.elkite.eattherainbow.managers.ShoppingItemManager


class ShoppingFragment : Fragment() {

    lateinit var binding: FragmentShoppingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoppingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.data = ShoppingFragmentDataBinding()
        binding.actions = ShoppingFragmentActions(this)

        ShoppingItemManager.getAllItemsByAddedToCart(false)
            .observe(viewLifecycleOwner, Observer { items ->
                handleShoppingData(items)
            })

        ShoppingItemManager.getAllItemsByAddedToCart(true)
            .observe(viewLifecycleOwner, Observer { items ->
                handleCartData(items)
            })

        val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition

                binding.data?.shoppingItems?.get(position)?.actions?.onSwipe()
            }
        }

        val touch = ItemTouchHelper(simpleItemTouchCallback)
        touch.attachToRecyclerView(binding.shoppingItemsRecyclerview)
    }

    private fun handleShoppingData(items: List<ShoppingItem>) {
        val dataItems = mutableListOf<ShoppingItemViewItem>()

        binding.data?.let {
            items.sortByCategory().mapIndexed { index, item ->
                dataItems.add(
                    ShoppingItemViewItem(
                        ShoppingItemDatabinding(
                            item.displayName,
                            item.quantity,
                            requireContext().getColor(item.category.colorId),
                            item.addedToCart
                        ), ShoppingItemActions(
                            onClick = {
                                binding.actions?.onClickCheckBox(item)
                            },
                            onSwipeAction = {
                                binding.actions?.onSwipeItem(item, index)
                            })
                    )
                )
            }
        }

        binding.data?.shoppingItems = dataItems
    }

    private fun handleCartData(items: List<ShoppingItem>) {
        val dataItems = mutableListOf<ShoppingItemViewItem>()

        binding.data?.let {
            items.sortByCategory().mapIndexed { index, item ->
                dataItems.add(
                    ShoppingItemViewItem(
                        ShoppingItemDatabinding(
                            item.displayName,
                            item.quantity,
                            requireContext().getColor(item.category.colorId),
                            item.addedToCart
                        ), ShoppingItemActions(
                            onClick = {
                                binding.actions?.onClickCheckBox(item)
                            },
                            onSwipeAction = {
                                binding.actions?.onSwipeItem(item, index)
                            })
                    )
                )
            }
        }

        binding.data?.cartItems = dataItems
    }
}