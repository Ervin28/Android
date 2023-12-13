package com.tasty.recipesapp.recipesapp.ui.recipe

import android.app.Activity
import android.content.ContentValues
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import fragments.recipe.viewmodel.RecipeDetailViewModel
import java.net.URL


class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeId = arguments?.getInt(RecipesFragment.BUNDLE_EXTRA_SELECTED_RECIPE_ID)

        Log.d(ContentValues.TAG, "show details of recipe with id: $recipeId")

        val viewModel = ViewModelProvider(this)[RecipeDetailViewModel::class.java]

        recipeId?.let { viewModel.fetchRecipeData(it) }

        viewModel.recipe.observe(viewLifecycleOwner) {
            Log.d(ContentValues.TAG, "show details of recipe with id: $it")
            updateViews(it)
        }
    }

    private fun updateViews(recipeModel: RecipeModel) {
        binding.recipeTitleView.text = recipeModel.name
        binding.recipeDescriptionView.text = recipeModel.description

        context?.let { context ->
            AsyncTask.execute {
                try {
                    val url = URL(recipeModel.thumbnailUrl)
                    val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    (context as Activity).runOnUiThread {
                        binding.recipeImageView.setImageBitmap(bitmap)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    // Handle exceptions, like setting a fallback image
                    (context as Activity).runOnUiThread {
                        binding.recipeImageView.setImageResource(R.drawable.background_image2)
                    }
                }
            }
        }

        val ratingsLabel = requireActivity().getString(R.string.user_ratings_label)

        binding.recipeRatingsView.text = ratingsLabel.plus(" ").plus(recipeModel.userRatings.score)

        binding.recipeTotalTimeView.text = recipeModel.totalTime.displayTier

        val instructionsString = recipeModel.instructions.joinToString("\n") {
            it.position.toString().plus(". ").plus(it.displayText)
        }

        binding.recipeInstructionsView.text = instructionsString
    }


}