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
            val order:Order = intent.getSerializableExtra("EXTRA_ORDER") as Order
            showReceipt(order)
        }

        binding.btnGoBack.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showReceipt(order: Order) {
        binding.tvReceipt.text = """
           Order Confirmed! Confirmation #: ${order.orderCode.toString()}  
           Your Receipt: 
           Pizza type:  ${order.typeOfPizza.toString()}
           Number of slices: ${order.numberOfSlices.toString()}
           Price per slice: ${'$'}${"%.2f".format(order.pricePerSlice)}
           Delivery cost: ${'$'}${"%.2f".format(order.deliveryCost)}
           Subtotal: ${'$'}${"%.2f".format(order.subtotal)}
           Tax (13%): ${'$'}${"%.2f".format(order.tax)}
           Total: ${'$'}${"%.2f".format(order.total)}
       """.trimIndent()
    }
}