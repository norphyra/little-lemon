package com.example.littlelemonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
            modifier = Modifier.size(width = 300.dp, height = 250.dp)
                .fillMaxWidth())

        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile image",
            Modifier
                .size(300.dp)
                .padding(top = 80.dp)
                .clickable { navController.navigate(com.example.littlelemonapp.navigation.Profile.route) })
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomePreview() {
//    Home()
//}