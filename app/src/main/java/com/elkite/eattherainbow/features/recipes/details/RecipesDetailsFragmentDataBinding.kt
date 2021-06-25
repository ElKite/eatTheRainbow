package com.elkite.eattherainbow.features.recipes.details

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.elkite.eattherainbow.BR

class RecipesDetailsFragmentDataBinding : BaseObservable() {

    @get:Bindable
    var recipesItem = listOf<RecipeViewItem>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.recipesItem)
        }
}
