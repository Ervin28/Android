package com.tasty.recipesapp.ui.recipe.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.RecipeListItemBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import kotlinx.coroutines.*
import java.net.URL

class RecipesListAdapter(
    private var recipeList: List<RecipeModel>,
    private val context: Context,
    private val onItemClickListener: (RecipeModel) -> Unit
) : RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val binding = RecipeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipeList[position]

        holder.recipeTitleView.text = currentRecipe.name
        holder.recipeDescriptionView.text = currentRecipe.description

        val rating = String.format("%.2f", currentRecipe.userRatings.score!! * 10).toDouble()
        holder.recipeRatingView.text = "$rating/10"

        coroutineScope.launch {
            val bitmap = withContext(Dispatchers.IO) {
                try {
                    BitmapFactory.decodeStream(URL(currentRecipe.thumbnailUrl).openConnection().getInputStream())
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
            bitmap?.let {
                holder.recipeImageView.setImageBitmap(it)
            } ?: holder.recipeImageView.setImageResource(R.drawable.background_image2)
        }
    }

    fun setData(newList: List<RecipeModel>) {
        recipeList = newList
        notifyDataSetChanged()
    }

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recipeTitleView: TextView = binding.recipeTitle
        val recipeDescriptionView: TextView = binding.recipeDescription
        val recipeImageView: ImageView = binding.recipePhoto
        val recipeRatingView: TextView = binding.recipeScore

        init {
            binding.root.setOnClickListener {
                val currentPosition = this.adapterPosition
                val currentRecipe = recipeList[currentPosition]
                onItemClickListener(currentRecipe)
            }
        }
    }

    override fun getItemCount(): Int = recipeList.size
}
