package com.example.model.response

data class MealCategoriesResponses(

     val categories:List<MealResponses>
    )


data class MealResponses(

     val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    var strCategoryDescription:String
)