package com.elkite.eattherainbow.features.recipes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elkite.eattherainbow.databinding.FragmentRecipesDetailsBinding

class RecipesDetailsFragment : Fragment() {

    private lateinit var binding: FragmentRecipesDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.data = RecipesDetailsFragmentDataBinding()
        binding.actions = RecipesDetailsActionsFragment()

    }
}