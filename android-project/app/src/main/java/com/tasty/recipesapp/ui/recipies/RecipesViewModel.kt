
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.repository.recipe.model.InstructionsDTO
import java.text.SimpleDateFormat
import java.util.*

class RecipesViewModel : ViewModel() {

    val instructionsLiveData = MutableLiveData<List<InstructionsDTO>>() // LiveData for holding the fetched instructions

    fun fetchOneRecipeInstruction(){
        val gson = Gson()
        val jsonString =
            """[{
            "appliance": null,
            "end_time": 26500,
            "temperature": null,
            "id": 43381,
            "position": 1,
            "display_text": "In a blender or food processor, combine the yogurt, lime
            juice, pepper, and chili powder and pulse to combine. Add ½ of the avocado and
            blend until creamy.",
            "start_time": 7000
            },
            {
            "appliance": null,
            "end_time": 26500,
            "temperature": null,
            "id": 43382,
            "position": 1,
            "display_text": "In a blender or food processor, combine the yogurt, lime
            juice, pepper, and chili powder and pulse to combine. Add ½ of the avocado and
            blend until creamy.",
            "start_time": 7000
            },
            {
            "appliance": null,
            "end_time": 26500,
            "temperature": null,
            "id": 43383,
            "position": 1,
            "display_text": "In a blender or food processor, combine the yogurt, lime
            juice, pepper, and chili powder and pulse to combine. Add ½ of the avocado and
            blend until creamy.",
            "start_time": 7000
            }]"""
        val test = gson.fromJson(jsonString, InstructionsDTO::class.java)


        val type = object : TypeToken<List<InstructionsDTO>>() {}.type
        val instructionList = gson.fromJson<List<InstructionsDTO>>(jsonString, type)
        Log.i("GSON", test.toString())

    }
    fun formatDate(date: Date): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(date)
    }

    // Example function to parse a date
    fun parseDate(dateString: String): Date {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.parse(dateString) ?: Date()
    }

    fun fetchAllInstructions(){

    }

    fun fetchRecipeInstructionsFromFile(){

    }


}