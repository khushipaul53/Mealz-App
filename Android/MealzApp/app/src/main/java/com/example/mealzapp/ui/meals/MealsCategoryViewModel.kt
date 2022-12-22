package com.example.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.MealRepository
import com.example.model.response.MealCategoriesResponses
import com.example.model.response.MealResponses
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


// view model will have the presentation logic
class MealsCategoryViewModel(private val respository:MealRepository= MealRepository()):ViewModel() {

   init{

       viewModelScope.launch(Dispatchers.IO) {
           val meal = getMeals()
           MealState.value = meal
       }
   }


    val MealState: MutableState<List<MealResponses>> =  mutableStateOf(emptyList<MealResponses>())

   suspend fun getMeals(): List<MealResponses>
    {

   return     respository.getMeals().categories

    }


}