package com.aaronbgrant.pizzaapp.model

import com.aaronbgrant.pizzaapp.model.ToppingPlacement.*

data class Pizza (
    val toppings: Map<Topping, ToppingPlacement> = emptyMap()
) {
    val price : Double
        get() = 9.99 + toppings.asSequence()
            .sumOf { (_, toppingPlacement) ->
                when (toppingPlacement) {
                    Left, Right -> 0.5
                    All -> 1.0
                }
            }
    fun withTopping(topping: Topping, placement: ToppingPlacement?): Pizza {
        return copy(
            toppings = if (placement == null) {
                toppings - topping
            } else {
                toppings + (topping to placement)
            }

        )

    }
}