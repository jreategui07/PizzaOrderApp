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

        binding.btnSubmitOrder.setOnClickListener {
            goToShowData(createOrder())
        }
    }

    private fun createOrder(): Order {
        val selectedRadioButtonId = binding.rgTypeOfPizza.checkedRadioButtonId
        var typeOfPizza:String = ""
        if (selectedRadioButtonId == R.id.rbVegetarian) { // binding.rbApple.id
            typeOfPizza = "vegetarian"
        } else if (selectedRadioButtonId == R.id.rbMeat) {
            typeOfPizza = "meat"
        }
        return Order(
            typeOfPizza,
            binding.etNumberOfSlices.toString().toInt(),
            binding.swEntirePizza.isChecked,
            binding.cbNeedDelivery.isChecked
        )
    }

    private fun goToShowData(order: Order) {
        val intent: Intent = Intent(this@MainActivity, Receipt::class.java)
         intent.putExtra("EXTRA_ORDER", order)
        startActivity(intent)
    }
}