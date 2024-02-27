package com.tasty.recipesapp.ui.profile

import InstructionTime
import InstructionsModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.userratings.model.UserRatingModel
import com.tasty.recipesapp.repository.recipe.model.RecipeModel

class NewRecipeFragment : Fragment() {

    private lateinit var binding: FragmentNewRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            Toast.makeText(context, "Creating new recipe...", Toast.LENGTH_SHORT).show()

            val newRecipe: RecipeModel = RecipeModel(
                id = 0,
                name = binding.recipeTitle.text.toString(),
                description = binding.recipeDescription.text.toString(),
                instruction = listOf(
                    InstructionsModel(
                        id = 0,
                        displayText = "Your instruction text here", // Replace with actual instruction
                        time = InstructionTime(startTime = 0, endTime = 0)
                    )
                ),
                thumbnailUrl = binding.recipePictureURL.text.toString(),
                userRating = UserRatingModel(countPositive = 10, countNegative = 0, score = 10.0f),
                yields = "4 servings", // Replace with actual yield
                keywords = "new, recipe", // Replace with actual keywords
                originalVideoUrl = binding.recipeVideoURL.text.toString()
            )

            RecipeRepository.insertMyRecipe(newRecipe)

            navigateToProfile()

        }
    }
    private fun navigateToProfile() {
        findNavController()
            .navigate(R.id.action_newRecipeFragment_to_profileFragment)
    }


}
