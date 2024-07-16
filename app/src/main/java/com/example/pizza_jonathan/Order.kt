package com.example.pizza_jonathan

import java.io.Serializable
import kotlin.random.Random

enum class PizzaSlice(val price: Double) {
    MEAT(6.70),
    VEGETARIAN(4.25)
}

val DELIVERY_COST: Double = 10.50

class Order: Serializable {
    var typeOfPizza: String = ""
    var numberOfSlices: Int = 0
    var entirePizza: Boolean = false
    var needDelivery: Boolean = false
    var subtotal: Double = 0.00
    var tax: Double = 0.00
    var total: Double = 0.00
    var orderCode: Int = 0

    constructor(
        typeOfPizza: String, // vegetarian/meat
        numberOfSlices: Int,
        entirePizza: Boolean,
        needDelivery: Boolean
    ) {
        this.typeOfPizza = typeOfPizza
        this.numberOfSlices = numberOfSlices
        this.entirePizza = entirePizza
        this.needDelivery = needDelivery
        this.subtotal = calculateSubtotal()
        this.tax = calculateTax()
        this.total = calculateTotal()
        this.orderCode = generateOrderCode()
    }

    private fun calculateSubtotal(): Double {
        val pricePerSlice = when (typeOfPizza) {
            "meat" -> PizzaSlice.MEAT.price
            "vegetarian" -> PizzaSlice.VEGETARIAN.price
            else -> 0.0
        }
        if (needDelivery) {
            return (numberOfSlices * pricePerSlice) + DELIVERY_COST
        } else {
            return numberOfSlices * pricePerSlice
        }
    }

    private fun calculateTax(): Double {
        return this.subtotal * 0.13
    }

    private fun calculateTotal(): Double {
        return subtotal + tax
    }

    private fun generateOrderCode(): Int {
        return Random.nextInt(1000, 9999)
    }
}
