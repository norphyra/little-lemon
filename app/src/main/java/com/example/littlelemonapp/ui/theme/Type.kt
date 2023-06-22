package com.example.littlelemonapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemonapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
)

val TitleTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.markazitext_medium, FontWeight.W500)),
        fontWeight = FontWeight.W500,
        fontSize = 64.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val SubTitleTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.markazitext_regular, FontWeight.W400)),
        fontWeight = FontWeight.W400,
        fontSize = 40.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val ParagraphTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular, FontWeight.W400)),
        fontWeight = FontWeight.W400,
        fontSize =42.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_medium, FontWeight.W500)),
        fontWeight = FontWeight.W500,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular, FontWeight.W400)),
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val SectionTitleTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_extrabold, FontWeight.W800)),
        fontWeight = FontWeight.W800,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val WeekSpecialSectionTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_extrabold, FontWeight.W800)),
        fontWeight = FontWeight.W800,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val CardTitleTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_bold, FontWeight.W700)),
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val HighlightTextTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_medium, FontWeight.W500)),
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

