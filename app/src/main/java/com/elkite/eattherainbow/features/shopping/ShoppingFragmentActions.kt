package com.elkite.eattherainbow.features.shopping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.entities.category.Category
import com.elkite.eattherainbow.entities.shopping.ShoppingItem
import com.elkite.eattherainbow.extensions.showSnackBar
import com.elkite.eattherainbow.managers.ShoppingItemManager
import com.elkite.eattherainbow.tools.helpers.actions.BaseFragmentActions
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShoppingFragmentActions(val fragment: ShoppingFragment) : BaseFragmentActions() {

    fun goToSearchFragment() {
        fragment.findNavController().navigate(R.id.action_navigation_shopping_to_search)
    }


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
                val productQuantity: Int = quantity.text.toString().toIntOrNull() ?: 1

                if (productName.isNotBlank())
                    launch(Dispatchers.IO) {
                        ShoppingItemManager.saveItem(
                            ShoppingItem(
                                product.text.toString(),
                                productQuantity,
                                category = Category.UNDEFINED
                            )
                        )
                    }
            }
            .setNegativeButton(R.string.common_cancel) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()
        alert.show()
    }

    fun onClickCheckBox(item: ShoppingItem) {
        item.addedToCart = !item.addedToCart

        launch(Dispatchers.IO) {
            ShoppingItemManager.updateItem(item)
        }
    }

    fun onSwipeItem(item: ShoppingItem, index: Int) {
        launch(Dispatchers.IO) {
            ShoppingItemManager.deleteItem(item)
        }

        fragment.context?.showSnackBar(
            descText = R.string.snack_bar_delete_item_desc,
            actionText = R.string.snack_bar_delete_item_action_cancel,
            action = View.OnClickListener {
                launch(Dispatchers.IO) {
                    ShoppingItemManager.saveItem(item)
                }
            },
            parentLayout = fragment.binding.parentLayout,
            length = Snackbar.LENGTH_LONG
        )
    }

    fun deleteAllCartItems() {
        launch(Dispatchers.IO) {
            ShoppingItemManager.deleteAllCartItems()
        }
    }

    fun unckeckAllCartItems() {
        launch(Dispatchers.IO) {
            ShoppingItemManager.uncheckAllCartItems()
        }
    }

}