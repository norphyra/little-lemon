package com.example.littlelemonapp

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemonapp.navigation.Onboarding
import com.example.littlelemonapp.ui.theme.Green
import com.example.littlelemonapp.ui.theme.Karla_Bold
import com.example.littlelemonapp.ui.theme.Karla_ExtraBold
import com.example.littlelemonapp.ui.theme.Karla_Regular
import com.example.littlelemonapp.ui.theme.LightGrey_highlight
import com.example.littlelemonapp.ui.theme.RedOrange_secondary
import com.example.littlelemonapp.ui.theme.Yellow

@Composable
fun Profile(navController: NavHostController, sharedPreferences: SharedPreferences) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(0.5f))

        Column(modifier = Modifier
            .padding(start = 25.dp, end = 20.dp, top = 80.dp)) {
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
            UserDataRow(text = sharedPreferences.getString("first name", "").toString())

            Text(text = "Last name",
                fontFamily = FontFamily(Karla_Bold),
                fontSize = 14.sp,
                color = Green,
                modifier = Modifier.padding(top = 40.dp)
            )
            UserDataRow(text = sharedPreferences.getString("last name", "").toString())

            Text(text = "Email",
                fontFamily = FontFamily(Karla_Bold),
                fontSize = 14.sp,
                color = Green,
                modifier = Modifier.padding(top = 40.dp)
            )
            UserDataRow(text = sharedPreferences.getString("email", "").toString())

            Button(onClick = {
                onClick(navController, sharedPreferences)
            },
                Modifier
                    .fillMaxWidth()
                    .padding(top = 160.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, RedOrange_secondary)
            ) {
                Text(text = "Log out", textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontFamily = FontFamily(Karla_Bold),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun UserDataRow(text: String) {
    Surface(shape = MaterialTheme.shapes.small,
        border = BorderStroke(1.dp, LightGrey_highlight),
        modifier = Modifier.clip(MaterialTheme.shapes.small)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text, color = Color.Black,
                fontFamily = FontFamily(Karla_Regular),
                fontSize = 16.sp
            )
        }
    }
}

fun onClick(navController: NavHostController, sharedPreferences: SharedPreferences)
{
    sharedPreferences.edit().clear().apply()
    navController.navigate(Onboarding.route)
}

//@Preview(showBackground = true)
//@Composable
//fun ProfilePreview() {
//    Profile()
//}