package com.tasty.recipesapp.ui.profile.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.repository.recipe.model.RecipeRepository


class ProfileViewModel(private val repository: RecipeRepository) : ViewModel() {
    //live data members
    var myRecipeList: MutableLiveData<List<RecipeModel>> =
        MutableLiveData()

    var insertResult: MutableLiveData<Boolean> =
        MutableLiveData()

    var deleteResult: MutableLiveData<Boolean> =
        MutableLiveData()

//    fun fetchMyRecipesData() {
//        val recipes = repository.getRecipes()
//        myRecipeList.value = recipes
//    }
}