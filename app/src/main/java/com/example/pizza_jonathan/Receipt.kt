package com.example.pizza_jonathan

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_jonathan.databinding.ActivityReceiptBinding

class Receipt : AppCompatActivity() {
    lateinit var binding: ActivityReceiptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent != null) {
            showReceipt()
        }

        binding.btnGoBack.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showReceipt() {
        binding.tvReceipt.text = """
           Order Confirmed! Confirmation #:  
           Your Receipt: 
           Pizza type: 
           Number of slices: 
           Price per slice:  
           Delivery cost:  
           Subtotal: 
           Tax (13%):  
           Total:  
       """.trimIndent()
    }
}