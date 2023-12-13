package com.tasty.recipesapp.repository.recipe.model

import android.content.Context
import android.util.Log
import repository.recipe.model.InstructionsModel
import repository.recipe.model.TotalTimeModel
import repository.recipe.model.UserRatingsModel
import java.io.IOException
data class RecipeModel (
    val id: Int,
    val name: String,
    val description: String?,
    val thumbnailUrl: String?,
    val userRatings: UserRatingsModel,
    val totalTime: TotalTimeModel,
    val instructions: List<InstructionsModel>
)

