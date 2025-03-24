package com.colorblindness.sdk.jh.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.colorblindness.sdk.jh.models.Types

class ColorSchemeProvider {

    // ====================
    // 🌈 BASIC COLORS
    // ====================
    private val baseRed = Color(0xFFFF0000)
    private val baseBrown = Color(0xFF8B4513)
    private val baseOrange = Color(0xFFFF7F00)
    private val basePurple = Color(0xFF800080)
    private val baseGreen = Color(0xFF00FF00)
    private val darkGreen = Color(0xFF006400)
    private val baseBlue = Color(0xFF0000FF)
    private val baseYellow = Color(0xFFFFFF00)
    private val white = Color(0xFFFFFFFF)
    private val black = Color(0xFF000000)

    // ====================
    // 🎨 COLORS BY TYPE
    // ====================

    // Protanopia (Red Blind)
    private val protanopiaColors = lightColorScheme(
        primary = basePurple,
        onPrimary = white,
        secondary = darkGreen,
        onSecondary = black,
        tertiary = baseBlue,
        onTertiary = white,
        surface = baseYellow,
        onSurface = black,
        background = white
    )

    // Deuteranopia (Green Blind)
    private val deuteranopiaColors = lightColorScheme(
        primary = baseRed,
        onPrimary = white,
        secondary = baseBrown,
        onSecondary = white,
        tertiary = baseBlue,
        onTertiary = white,
        surface = baseYellow,
        onSurface = black,
        background = white
    )

    // Tritanopia (Blue-Yellow Blind)
    private val tritanopiaColors = lightColorScheme(
        primary = baseRed,
        onPrimary = white,
        secondary = darkGreen,
        onSecondary = black,
        tertiary = basePurple,
        onTertiary = white,
        surface = baseOrange,
        onSurface = black,
        background = white
    )

    fun getColorScheme(type: Types): ColorScheme  {
        return when (type) {
            Types.PROTANOPIA -> protanopiaColors
            Types.DEUTERANOPIA -> deuteranopiaColors
            Types.TRITANOPIA -> tritanopiaColors
        }
    }
}