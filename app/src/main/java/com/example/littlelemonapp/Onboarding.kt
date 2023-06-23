package com.example.littlelemonapp

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.littlelemonapp.ui.theme.Green
import com.example.littlelemonapp.ui.theme.Karla_Bold
import com.example.littlelemonapp.ui.theme.Karla_ExtraBold
import com.example.littlelemonapp.ui.theme.Karla_Regular
import com.example.littlelemonapp.ui.theme.RedOrange_secondary
import com.example.littlelemonapp.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoarding(navController: NavHostController, sharedPreferences: SharedPreferences) {

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

        val context = LocalContext.current

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
                fontSize = 14.sp,
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
                fontSize = 14.sp,
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
                fontSize = 14.sp,
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

            Button(onClick = {
                onClick(context, sharedPreferences, navController, firstName, lastName, email)
                             },
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

fun onClick(context: Context, sharedPreferences: SharedPreferences, navController: NavHostController,
            firstName: String, lastName: String, email: String)
{

    if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
        with(sharedPreferences.edit()) {
            putBoolean("isLogin", true)
            putString("first name", firstName)
            putString("last name", lastName)
            putString("email", email)
            apply()
        }
        navController.navigate(com.example.littlelemonapp.navigation.Home.route)
    } else {
        Toast.makeText(context, "Registration unsuccessful. Please enter all data.", Toast.LENGTH_SHORT).show()
    }
}