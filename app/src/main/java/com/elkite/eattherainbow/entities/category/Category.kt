package com.elkite.eattherainbow.entities.category

import androidx.room.TypeConverter
import com.elkite.eattherainbow.R

enum class Category {
    VEGETABLES {
        override val nameId: Int = R.string.category_vegetables
        override val colorId: Int = R.color.category_vegetables
    },
    MEAT {
        override val nameId: Int = R.string.category_meat
        override val colorId: Int = R.color.category_meat
    },
    FRUITS {
        override val nameId: Int = R.string.category_fruits
        override val colorId: Int = R.color.category_fruits
    },
    UNDEFINED {
        override val nameId: Int = R.string.category_undefined
        override val colorId: Int = R.color.category_undefined
    },
    MILKS {
        override val nameId: Int = R.string.category_milks
        override val colorId: Int = R.color.category_milks
    },
    CEREALS {
        override val nameId: Int = R.string.category_cereals
        override val colorId: Int = R.color.category_cereals
    },
    SPORT {
        override val nameId: Int = R.string.category_sport
        override val colorId: Int = R.color.category_sport
    };

    abstract val nameId: Int
    abstract val colorId: Int
}

class CategoryConverter {

    @TypeConverter
    fun fromCategory(category: Category): String {
        return category.name
    }

    @TypeConverter
    fun toCategory(category: String): Category {
        return Category.valueOf(category)
    }

}