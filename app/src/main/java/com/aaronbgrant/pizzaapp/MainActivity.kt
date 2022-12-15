package com.aaronbgrant.pizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.aaronbgrant.pizzaapp.navigation.Screen
import com.aaronbgrant.pizzaapp.navigation.SetupNavGraph
import com.aaronbgrant.pizzaapp.ui.AppTheme
import com.aaronbgrant.pizzaapp.ui.PizzaBuilderScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, Screen.Splash.route)
            }
        }
    }
}