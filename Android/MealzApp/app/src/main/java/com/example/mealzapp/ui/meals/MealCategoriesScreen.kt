package com.example.mealzapp.ui.meals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mealzapp.R
import com.example.mealzapp.ui.theme.MealzAppTheme
import com.example.model.response.MealResponses


@Composable
fun MealCategoriesScreen() {
    val mealCategoryViewModel :MealsCategoryViewModel= viewModel()
    val meal=mealCategoryViewModel.MealState.value
    LazyColumn{
        items(meal){meals->
            MealCategory(meals)


        }
    }
}
@Composable
fun MealCategory(meal: MealResponses){
    Card(shape= RoundedCornerShape(8.dp), elevation = 2.dp, modifier = Modifier
        .fillMaxWidth()
        .padding(top=16.dp)
    )

    {
        Row{
            // Image
//
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(meal.strCategoryThumb)
//                    .crossfade(true)
//                    .build(),
//                placeholder = painterResource(R.drawable.ic_launcher_background),
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.clip(CircleShape)
//            )
            AsyncImage(
                model = meal.strCategoryThumb,
                contentDescription = null
            )

            Column {
                Text(text=meal.strCategory)


            }

        }
    }


}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealCategoriesScreen()
    }
}