package com.example.pizza_jonathan

data class PizzaSlice(val type: String, val price: Double) {
    companion object {
        val MEAT = PizzaSlice("meat", 6.70)
        val VEGETARIAN = PizzaSlice("vegetarian", 4.25)
    }
}
