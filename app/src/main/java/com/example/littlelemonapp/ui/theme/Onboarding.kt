package com.example.littlelemonapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemonapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding() {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(Green)
            .height(20.dp)
            .fillMaxWidth()) {
            Text(text = "Let's get to know you", color = Color.White)
        }
        TextField(value = firstName, onValueChange = {firstName = it}, label = { Text(text = "First Name")})
        TextField(value = lastName, onValueChange = {lastName = it}, label = { Text(text = "Last Name")})
        TextField(value = email, onValueChange = {email = it}, label = { Text(text = "Email")})
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    Onboarding()
}