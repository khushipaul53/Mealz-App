package com.example.model

import com.example.model.api.mealsWebServices
import com.example.model.response.MealCategoriesResponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(private val mealsWebServices: mealsWebServices=mealsWebServices()) {

   suspend fun getMeals() :MealCategoriesResponses{
//      return mealsWebServices.getMeals().execute().body()!!    // Bad practises

        return mealsWebServices.getMeals()


    }
}