package com.example.littlelemonapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.littlelemonapp.model.MenuDatabase
import com.example.littlelemonapp.model.MenuItemEntity
import com.example.littlelemonapp.model.MenuItemNetwork
import com.example.littlelemonapp.ui.theme.Green
import com.example.littlelemonapp.ui.theme.Karla_Bold
import com.example.littlelemonapp.ui.theme.Karla_ExtraBold
import com.example.littlelemonapp.ui.theme.Karla_Medium
import com.example.littlelemonapp.ui.theme.Karla_Regular
import com.example.littlelemonapp.ui.theme.LightGrey_highlight
import com.example.littlelemonapp.ui.theme.MarkaziText_Medium
import com.example.littlelemonapp.ui.theme.MarkaziText_Regular
import com.example.littlelemonapp.ui.theme.Yellow
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, menuItems: LiveData<List<MenuItemEntity>>, onClick: (String) -> Unit) {

    val menuCategory = listOf("Starters", "Mains", "Desserts", "Sides")
    val menuItems by menuItems.observeAsState(initial = emptyList())

    var selectedCategory by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        var searchPhrase by remember {
            mutableStateOf("")
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
            modifier = Modifier.size(179.dp, 56.dp))

            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile image",
                Modifier
                    .padding(start = 46.dp, end = 40.dp)
                    .size(50.dp)
                    .clickable {
                        navController.navigate(com.example.littlelemonapp.navigation.Profile.route)
                    })
        }
        Surface(color = Green) {

            Text(text = stringResource(id = R.string.title), fontFamily = FontFamily(MarkaziText_Medium),
                fontSize = 64.sp,
                color = Yellow,
                modifier = Modifier.padding(end = 22.dp, start = 22.dp))

            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 22.dp, end = 22.dp, top = 60.dp)
                    .wrapContentHeight(unbounded = true)
            ) {
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 29.dp)
                        .wrapContentHeight(),
                ) {
                    Column(Modifier.padding(8.dp)) {

                        Text(text = stringResource(id = R.string.city), fontFamily = FontFamily(MarkaziText_Regular),
                            fontSize = 40.sp,
                            color = Color.White)

                        Text(text = stringResource(id = R.string.description),
                            fontFamily = FontFamily(Karla_Medium),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .fillMaxHeight(0.19f)
                                .padding(top = 16.dp))
                    }

                    Image(painter = painterResource(id = R.drawable.hero_image),
                        contentDescription = "hero image",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .size(140.dp)
                    )
                }

                OutlinedTextField(value = searchPhrase,
                    onValueChange = {searchPhrase = it},
                    colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = LightGrey_highlight,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Green),
                    placeholder = {
                        Text(
                            text = "Enter search phrase",
                            color = Green,
                            fontFamily = FontFamily(Karla_Medium),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    },
                    leadingIcon =
                        { Icon( imageVector = Icons.Default.Search, contentDescription = "",)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true
                )
            }

        }

        Text(text = "ORDER FOR DELIVERY!", fontFamily = FontFamily(
            Karla_ExtraBold),
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 40.dp, bottom = 15.dp))

        LazyRow(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)

        ) {
            items(menuCategory) {
                MenuCategoryItem(it, onClick)
            }
        }

        Divider(thickness = 1.dp, color = LightGrey_highlight,
            modifier = Modifier.padding(top = 30.dp, bottom = 15.dp, start = 20.dp, end = 20.dp))

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(menuItems.filter { it.title.contains(searchPhrase, ignoreCase = true)
            }) {
                Dish(it)
            }
        }

    }
}

@Composable
fun Dish(item: MenuItemEntity) {
    Column(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            ) {
        Text(text = item.title,
            fontFamily = FontFamily(Karla_Bold),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .wrapContentHeight(unbounded = true))
        Row(verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
           Column(modifier = Modifier
               .padding(end = 8.dp)
               .weight(1f)) {
               Text(text = item.description, color = Green,
                   fontFamily = FontFamily(Karla_Regular),
                   fontSize = 16.sp)
               Text(text = "$${item.price}", color = Green,
                   fontFamily = FontFamily(Karla_Medium),
                   fontSize = 18.sp)
           }
            AsyncImage(model = item.image, contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp))
        }

        Divider(thickness = 1.dp, color = LightGrey_highlight,
            modifier = Modifier.padding(top = 15.dp, start = 20.dp, end = 20.dp))
    }

}

@Composable
fun MenuCategoryItem(category: String, onClick: (String) -> Unit) {
    Surface(shape = RoundedCornerShape(12.dp), color = LightGrey_highlight,
    modifier = Modifier.clickable {
        onClick(category.lowercase())
    }) {
        Text(
            text = category, fontFamily = FontFamily(
                Karla_Bold
            ),
            fontSize = 16.sp,
            color = Green,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 9.dp, end = 9.dp, top = 7.dp, bottom = 7.dp)

        )
    }
}



@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()

    val items = MutableLiveData(listOf(
        MenuItemNetwork(1, "Greek Salad", "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.", "10", "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true", "starters"),
        MenuItemNetwork(2, "Greek Salad", "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.", "10", "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true", "starters"),
        MenuItemNetwork(3, "Greek Salad", "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.", "10", "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true", "starters")))


//    Home(navController, items)
}