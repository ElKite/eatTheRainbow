package com.elkite.eattherainbow.components.ingredient

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.elkite.eattherainbow.R
import com.elkite.eattherainbow.databinding.ViewIngredientItemBinding

class IngredientItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var binding: ViewIngredientItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.view_ingredient_item,
        this,
        true
    )

    fun bindData(viewTypeDataBinding: IngredientViewItem) {
        binding.viewItem = viewTypeDataBinding
    }

}