package com.example.littlelemonapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonapp.ui.theme.Green
import com.example.littlelemonapp.ui.theme.Karla_Bold
import com.example.littlelemonapp.ui.theme.Karla_ExtraBold
import com.example.littlelemonapp.ui.theme.Karla_Regular
import com.example.littlelemonapp.ui.theme.RedOrange_secondary
import com.example.littlelemonapp.ui.theme.Yellow

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

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(0.5f))

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Green)
                .height(110.dp)
                .fillMaxWidth()) {
            Text(text = "Let's get to know you", color = Color.White,
                fontFamily = FontFamily(Karla_Regular),
                fontSize = 24.sp
            )
        }

        Column(modifier = Modifier
            .padding(start = 25.dp, end = 20.dp)) {
            Text(text = "Personal information", color = Color.Black,
                fontFamily = FontFamily(Karla_ExtraBold),
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 45.dp, bottom = 60.dp)
            )

            Text(text = "First name",
                fontFamily = FontFamily(Karla_Bold),
                fontSize = 16.sp,
                color = Green,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            OutlinedTextField(value = firstName, onValueChange = {firstName = it},
                modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Green,
                unfocusedBorderColor = Green
            ))

            Text(text = "Last name",
                fontFamily = FontFamily(Karla_Bold),
                fontSize = 16.sp,
                color = Green,
                modifier = Modifier.padding(top = 40.dp)
            )
            OutlinedTextField(value = lastName, onValueChange = {lastName = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Green
                ))

            Text(text = "Email",
                fontFamily = FontFamily(Karla_Bold),
                fontSize = 16.sp,
                color = Green,
                modifier = Modifier.padding(top = 40.dp)
            )
            OutlinedTextField(value = email, onValueChange = {email = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Green
                ))

            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(top = 110.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, RedOrange_secondary)
            ) {
                Text(text = "Register", textAlign = TextAlign.Center,
                color = Color.Black,
                fontFamily = FontFamily(Karla_Regular),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun TextFieldLabel(label: String) {

    Text(text = label,
        fontFamily = FontFamily(Karla_Bold),
        fontSize = 16.sp,
        color = Green
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}