import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.ui.recipe.adapter.RecipesListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val TAG: String? = ProfileFragment::class.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: RecipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        val recyclerView: RecyclerView = binding.recipesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        context?.let { viewModel.fetchMyRecipeData() }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes: List<RecipeModel> ->
            val adapter = RecipesListAdapter(
                recipes,
                requireContext(),
                onItemClick = { currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe) },
                onDetailsClick = { currentRecipe: RecipeModel ->
                    navigateToRecipeDetail(currentRecipe)
                }
            )
            recyclerView.adapter = adapter

            recipes.forEach { recipe ->
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.description}")
                Log.d(TAG, "Recipe instruction: ${recipe.instruction}")
                Log.d(TAG, "----------")
            }
        }

        binding.addRecipe.setOnClickListener {
            Log.d(TAG, "Clicked")
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }
}
