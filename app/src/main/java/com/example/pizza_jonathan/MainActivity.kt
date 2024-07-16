package com.example.pizza_jonathan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_jonathan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rgTypeOfPizza.setOnCheckedChangeListener { group, checkedId ->
            typeOfPizzaRadioGroupPressed(checkedId)
        }


        binding.swEntirePizza.setOnClickListener {
            entirePizzaSwitchPressed()
        }

        binding.btnSubmitOrder.setOnClickListener {
            checkValues()
        }
    }

    private fun typeOfPizzaRadioGroupPressed(checkedPizzaId: Int) {
        if (checkedPizzaId == R.id.rbVegetarian) {
            binding.ivPizza.setImageResource(R.drawable.pizza_vegetarian)
        } else if (checkedPizzaId == R.id.rbMeat) {
            binding.ivPizza.setImageResource(R.drawable.pizza_meat)
        }
    }

    private fun entirePizzaSwitchPressed() {
        val isEntirePizza: Boolean = binding.swEntirePizza.isChecked
        if (isEntirePizza == true) {
            binding.etNumberOfSlices.setText("8")
        } else {
            binding.etNumberOfSlices.setText("0")
        }
    }

    private fun checkValues() {
        val selectedRadioButtonId = binding.rgTypeOfPizza.checkedRadioButtonId
        var typeOfPizza:String = ""
        if (selectedRadioButtonId == R.id.rbVegetarian) {
            typeOfPizza = PizzaSlice.VEGETARIAN.type
        } else if (selectedRadioButtonId == R.id.rbMeat) {
            typeOfPizza = PizzaSlice.MEAT.type
        } else {
            binding.tvValidations.text = "Select a type of Pizza"
            return
        }

        val numberOfSlices = binding.etNumberOfSlices.text.toString().toIntOrNull() ?: 0
        if (numberOfSlices <= 0) {
            binding.tvValidations.text = "Enter the number of slices"
            return
        }

        goToShowData(Order(
            typeOfPizza,
            numberOfSlices,
            binding.cbNeedDelivery.isChecked
        ))
    }

    private fun goToShowData(order: Order) {
        val intent: Intent = Intent(this@MainActivity, Receipt::class.java)
         intent.putExtra("EXTRA_ORDER", order)
         startActivity(intent)
    }
}