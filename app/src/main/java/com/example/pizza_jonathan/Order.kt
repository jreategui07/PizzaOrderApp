package com.example.pizza_jonathan

import java.io.Serializable
import kotlin.random.Random

class Order: Serializable {
    var typeOfPizza: String = ""
    var numberOfSlices: Int = 0
    var pricePerSlice: Double = 0.00
    var deliveryCost: Double = 0.00
    var subtotal: Double = 0.00
    var tax: Double = 0.00
    var total: Double = 0.00
    var orderCode: Int = 0

    constructor(
        typeOfPizza: String,
        numberOfSlices: Int,
        needDelivery: Boolean
    ) {
        this.typeOfPizza = typeOfPizza
        this.numberOfSlices = numberOfSlices
        this.deliveryCost = getDeliveryCost(needDelivery)
        this.pricePerSlice = calculatePricePerSlice()
        this.subtotal = calculateSubtotal()
        this.tax = calculateTax()
        this.total = calculateTotal()
        this.orderCode = generateOrderCode()
    }

    private fun calculatePricePerSlice(): Double {
        if (this.typeOfPizza == PizzaSlice.MEAT.type) {
            return PizzaSlice.MEAT.price
        } else if (this.typeOfPizza == PizzaSlice.VEGETARIAN.type) {
            return PizzaSlice.VEGETARIAN.price
        }
        return 0.00
    }

    private fun getDeliveryCost(needDelivery: Boolean): Double {
        if (needDelivery == true) {
            return Constants.DELIVERY_FEE
        }
        return 0.00
    }

    private fun calculateSubtotal(): Double {
        return (this.numberOfSlices * this.pricePerSlice) + this.deliveryCost
    }

    private fun calculateTax(): Double {
        return this.subtotal * 0.13
    }

    private fun calculateTotal(): Double {
        return this.subtotal + this.tax
    }

    private fun generateOrderCode(): Int {
        return Random.nextInt(1000, 9999)
    }
}
