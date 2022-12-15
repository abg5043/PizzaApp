package com.aaronbgrant.pizzaapp

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

//extending Context with a singleton dataStore
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="LocalStore")
class PizzaAppApplication: Application() {

}