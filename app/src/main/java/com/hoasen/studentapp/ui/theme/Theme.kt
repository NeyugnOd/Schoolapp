package com.hoasen.studentapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val HoaSenBlue = Color(0xFF0A3D91)
val HoaSenBlueDark = Color(0xFF072C6B)
val HoaSenRed = Color(0xFFE11D2A)
val HoaSenYellow = Color(0xFFFFC72C)
val HoaSenGreen = Color(0xFF2BB673)
val BgGray = Color(0xFFF3F4F6)
val TextPrimary = Color(0xFF1F2937)
val TextSecondary = Color(0xFF6B7280)

private val LightColors = lightColorScheme(
    primary = HoaSenBlue,
    onPrimary = Color.White,
    secondary = HoaSenRed,
    onSecondary = Color.White,
    background = BgGray,
    onBackground = TextPrimary,
    surface = Color.White,
    onSurface = TextPrimary
)

@Composable
fun HoaSenTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
