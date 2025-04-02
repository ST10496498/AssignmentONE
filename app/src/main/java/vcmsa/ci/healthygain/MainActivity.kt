package vcmsa.ci.healthygain

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val timeOfDayEditText: EditText = findViewById(R.id.zwanoSearch)
        val showMealButton: Button = findViewById(R.id.Showmealbutton)
        val resetButton: Button = findViewById(R.id.Resetbutton)
        val mealSuggestionsTextView: TextView = findViewById(R.id.Healthyfoodtextview)

        // Show meal suggestions when button is clicked
        showMealButton.setOnClickListener {
            val timeOfDay = timeOfDayEditText.text.toString().trim()

            if (timeOfDay.isEmpty()) {
                // Show a Toast if no time of day is entered
                Toast.makeText(this,"Please enter a time of day",Toast.LENGTH_SHORT).show()
            } else {
                // Display meal suggestions based on the time of day
                val mealSuggestions = when (timeOfDay.lowercase()) {
                    "morning" -> {
                        "Breakfast: Plain Yoghurt and Muesli\nOatmeal"
                    }
                    "mid-morning" -> {
                        "Snack: Protein Bar\nBiscuit"
                    }
                    "afternoon" -> {
                        "Lunch: Bombay Potato Frittata\nChicken Satay Salad"
                    }
                    "mid-afternoon" -> {
                        "Snack: Trail Mix\nCheese Strings"
                    }
                    "Dinner" -> {
                        "Dinner: Cottage Cheese Alfredo\nChicken and Broccoli"
                    }
                    "after dinner" -> {
                        "Dessert: Apricot and Raspberry Tart\nChocolate and Berry Mousse Pots"
                    } else -> {
                        "Invalid time of day. Please enter a valid time."
                    }
                }
                // Show the meal suggestions in the TextView
                mealSuggestionsTextView.text = mealSuggestions
            }
        }
        // Reset the input and suggestions when reset button is clicked
        resetButton.setOnClickListener {
            timeOfDayEditText.text.clear()
            mealSuggestionsTextView.text =""
        }

    }
}
