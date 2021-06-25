package com.elkite.eattherainbow.entities.shopping

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elkite.eattherainbow.entities.category.Category

@Entity
class ShoppingItem(
    var displayName: String,
    var quantity: Int,
    var addedToCart: Boolean = false,
    var category: Category

) {
    @PrimaryKey(autoGenerate = true)  var id: Int = 0
}

fun List<ShoppingItem>.sortByCategory(): List<ShoppingItem> {

    return sortedWith(
        compareBy({ it.category.name }, { it.displayName }
        )
    )
}