package com.tasty.recipesapp.repository.recipe.userratings.model

data class UserRatingModel(
    val countPositive: Int,
    val countNegative: Int,
    val score: Float
)