import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel


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