package com.colorblindness.sdk.jh.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.colorblindness.sdk.jh.models.Types

class ColorSchemeProvider {

    private val red = Color(0xFFE53935)
    private val green = Color(0xFF43A047)
    private val blue = Color(0xFF1E88E5)
    private val yellow = Color(0xFFFFEB3B)
    private val purple = Color(0xFF8E24AA)
    private val brown = Color(0xFF6D4C41)
    private val orange = Color(0xFFFFA726)
    private val black = Color(0xFF000000)
    private val white = Color(0xFFFFFFFF)
    private val gray = Color(0xFFBDBDBD)

    // Lichte thema's
    private val protanopiaLight = lightColorScheme(
        primary = purple,
        onPrimary = white,
        secondary = green,
        onSecondary = black,
        tertiary = blue,
        onTertiary = white,
        background = white,
        onBackground = black,
        surface = yellow,
        onSurface = black,
        error = red,
        onError = white
    )

    private val deuteranopiaLight = lightColorScheme(
        primary = red,
        onPrimary = white,
        secondary = brown,
        onSecondary = white,
        tertiary = blue,
        onTertiary = white,
        background = white,
        onBackground = black,
        surface = yellow,
        onSurface = black,
        error = orange,
        onError = black
    )

    private val tritanopiaLight = lightColorScheme(
        primary = red,
        onPrimary = white,
        secondary = green,
        onSecondary = black,
        tertiary = purple,
        onTertiary = white,
        background = white,
        onBackground = black,
        surface = orange,
        onSurface = black,
        error = blue,
        onError = white
    )

    // Donkere thema's
    private val protanopiaDark = darkColorScheme(
        primary = purple,
        onPrimary = white, // Veranderd naar white voor betere zichtbaarheid in dark mode
        secondary = green,
        onSecondary = black, // Veranderd naar black voor betere zichtbaarheid in dark mode
        tertiary = blue,
        onTertiary = white, // Veranderd naar white voor betere zichtbaarheid in dark mode
        background = Color(0xFF121212),
        onBackground = white,
        surface = gray,
        onSurface = white,
        error = red,
        onError = white
    )

    private val deuteranopiaDark = darkColorScheme(
        primary = red,
        onPrimary = white, // Veranderd naar white voor betere zichtbaarheid in dark mode
        secondary = brown,
        onSecondary = white,
        tertiary = blue,
        onTertiary = white, // Veranderd naar white voor betere zichtbaarheid in dark mode
        background = Color(0xFF121212),
        onBackground = white,
        surface = gray,
        onSurface = white,
        error = orange,
        onError = black
    )

    private val tritanopiaDark = darkColorScheme(
        primary = red,
        onPrimary = white,
        secondary = green,
        onSecondary = black,
        tertiary = purple,
        onTertiary = white,
        background = Color(0xFF121212),
        onBackground = white,
        surface = gray,
        onSurface = white,
        error = blue,
        onError = white
    )

    fun getColorScheme(type: Types, isDarkTheme: Boolean = false): ColorScheme {
        return when (type) {
            Types.PROTANOPIA -> if (isDarkTheme) protanopiaDark else protanopiaLight
            Types.DEUTERANOPIA -> if (isDarkTheme) deuteranopiaDark else deuteranopiaLight
            Types.TRITANOPIA -> if (isDarkTheme) tritanopiaDark else tritanopiaLight
        }
    }
}