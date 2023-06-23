package com.example.littlelemonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemonapp.model.MenuDatabase
import com.example.littlelemonapp.model.MenuItemEntity
import com.example.littlelemonapp.ui.theme.Green
import com.example.littlelemonapp.ui.theme.Karla_Bold
import com.example.littlelemonapp.ui.theme.Karla_ExtraBold
import com.example.littlelemonapp.ui.theme.Karla_Medium
import com.example.littlelemonapp.ui.theme.LightGrey_highlight
import com.example.littlelemonapp.ui.theme.MarkaziText_Medium
import com.example.littlelemonapp.ui.theme.MarkaziText_Regular
import com.example.littlelemonapp.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, menuItems: MutableLiveData<List<MenuItemEntity>>) {

    val menuCategory = listOf("Starters", "Mains", "Desserts", "Sides")
    val menuItems by menuItems.observeAsState(initial = emptyList())

    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
    ) {
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
            Column(modifier = Modifier.padding(start = 22.dp, end = 22.dp)) {

                var searchValue by remember {
                    mutableStateOf("")
                }

                Text(text = stringResource(id = R.string.title), fontFamily = FontFamily(MarkaziText_Medium),
                fontSize = 64.sp,
                color = Yellow)

                Text(text = stringResource(id = R.string.city), fontFamily = FontFamily(MarkaziText_Regular),
                    fontSize = 40.sp,
                    color = Color.White)

                Row(modifier = Modifier.fillMaxWidth().padding(bottom = 29.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = stringResource(id = R.string.description),
                        fontFamily = FontFamily(Karla_Medium),
                        fontSize = 18.sp,
                        color = Color.White,
                    modifier = Modifier.size(231.dp, 105.dp))
                    Image(painter = painterResource(id = R.drawable.hero_image), contentDescription = "hero image",
                        Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .size(100.dp),
                    contentScale = ContentScale.Crop)
                }
                OutlinedTextField(value = searchValue,
                    onValueChange = {searchValue = it},
                    colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = LightGrey_highlight,
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Green),
                    placeholder = {
                                  Text(
                                      text = "Enter search phrase",
                                      color = Green,
                                      fontFamily = FontFamily(Karla_Medium),
                                      fontSize = 18.sp,
                                      modifier = Modifier.fillMaxWidth(),
                                      textAlign = TextAlign.Center
                                  )
                    },
                    leadingIcon = {
                                  Image(imageVector = ImageVector.vectorResource(id = R.drawable.search_icon_24), contentDescription = "search icon")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp)
                        .height(62.dp),
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }

        Column(modifier = Modifier.padding(start = 22.dp, end = 22.dp)) {
            Text(text = "ORDER FOR DELIVERY!", fontFamily = FontFamily(
                Karla_ExtraBold),
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 40.dp, bottom = 15.dp))

            LazyRow(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                items(menuCategory) {
                    MenuCategoryItem(it)
                }
            }

            Divider(thickness = 1.dp, color = LightGrey_highlight,
                modifier = Modifier.padding(top = 30.dp, bottom = 30.dp))
        }

        LazyColumn {
            items(menuItems) {
                Dish(it)
            }
        }

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Dish(item: MenuItemEntity) {

    println(item)

    Column {
        Text(text = item.title)
        Row {
           Column() {
               Text(text = item.description)
               Text(text = item.price)
           }
            GlideImage(model = item.image, contentDescription = item.title)
        }
    }

}

@Composable
fun MenuCategoryItem(category: String) {
    Surface(shape = RoundedCornerShape(12.dp), color = LightGrey_highlight) {
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



//@Preview(showBackground = true)
//@Composable
//fun HomePreview() {
//    Home()
//}