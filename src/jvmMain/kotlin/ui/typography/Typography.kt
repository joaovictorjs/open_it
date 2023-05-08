package ui.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

val TypographyProvider = staticCompositionLocalOf { Typography() }

val roboto = FontFamily(
    listOf(
        Font(resource = "fonts/roboto_light.ttf", weight = FontWeight.Light),
        Font(resource = "fonts/roboto_regular.ttf", weight = FontWeight.Normal),
        Font(resource = "fonts/roboto_medium.ttf", weight = FontWeight.Medium),
        Font(resource = "fonts/roboto_bold.ttf", weight = FontWeight.Bold),
    )
)

data class Typography(
    val family: FontFamily = roboto,
    val fontColor: Color = Color.Transparent,
    val title: TextStyle = TextStyle(
        color = fontColor,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        fontFamily = family,
    ),
    val body: TextStyle = TextStyle(
        color = fontColor,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontFamily = family,
    ),
)