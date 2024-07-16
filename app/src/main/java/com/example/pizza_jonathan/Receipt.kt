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
           Order Confirmed! Confirmation #: ${order.orderCode}  
           Your Receipt: 
           Pizza type:  ${order.typeOfPizza}
           Number of slices: ${order.numberOfSlices}
           Subtotal:  ${order.subtotal}
           Tax (13%):  ${order.tax}
           Total:  ${order.total}
       """.trimIndent()
    }
}