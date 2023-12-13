package com.tasty.recipesapp.recipesapp.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.ui.recipe.adapter.RecipesListAdapter
import fragments.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {

    companion object {
        private val TAG = RecipesFragment::class.java.canonicalName
        const val BUNDLE_EXTRA_SELECTED_RECIPE_ID = "selected_recipe_id"
    }

    private lateinit var binding: FragmentRecipesBinding
    private lateinit var recipesAdapter: RecipesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecipesBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel= ViewModelProvider(this).get(RecipeListViewModel::class.java)

        context?.let{
            viewModel.fetchRecipesData(it)
        }

        viewModel.recipesList.observe(viewLifecycleOwner){ recipes: List<RecipeModel> ->
            recipesAdapter.setData(recipes)
            recipesAdapter.notifyItemRangeChanged(0,recipes.lastIndex)
        }
    }

    private fun initRecyclerView(){
        recipesAdapter = RecipesListAdapter(ArrayList(), requireContext(),
            onItemClickListener = { recipe: RecipeModel ->  // Explicitly specifying the type
                navigateToRecipeDetails(recipe)
            })
        binding.recipesRecyclerView.adapter = recipesAdapter
        binding.recipesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.recipesRecyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
    }


    private fun navigateToRecipeDetails(recipe: RecipeModel){
        findNavController().navigate(
            R.id.action_recipesFragment_to_recipeDetailFragment,
            bundleOf(
                BUNDLE_EXTRA_SELECTED_RECIPE_ID to recipe.id
            )
        )

    }

}