package com.aaronbgrant.pizzaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.aaronbgrant.pizzaapp.ui.PizzaBuilderScreen
import com.aaronbgrant.pizzaapp.ui.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        //anonymous composable
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            PizzaBuilderScreen()
        }
    }
}