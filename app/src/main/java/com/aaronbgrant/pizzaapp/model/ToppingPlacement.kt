package com.aaronbgrant.pizzaapp.model

import androidx.annotation.StringRes
import com.aaronbgrant.pizzaapp.R

enum class ToppingPlacement(
    @StringRes val label: Int
    ) {
    Left(R.string.placement_left),
    Right(R.string.placement_right),
    All(R.string.placement_all)
}

enum class Topping(
    @StringRes val toppingName: Int
    ) {
    Basil( toppingName = R.string.topping_basil ),

    Mushroom( toppingName = R.string.topping_mushroom ),

    Olive( toppingName = R.string.topping_olive ),

    Peppers( toppingName = R.string.topping_peppers ),

    Pepperoni( toppingName = R.string.topping_pepperoni ),

    Pineapple( toppingName = R.string.topping_pineapple )
}