package com.colorblindness.sdk.jh.ui.theme

import androidx.compose.ui.graphics.Color
import com.colorblindness.sdk.jh.models.Types

class ColorSchemeProvider {

    // ====================
    // 🌈 BASIC COLORS
    // ====================
    private val baseRed = Color(0xFFFF0000)
    private val baseGreen = Color(0xFF00FF00)
    private val baseBlue = Color(0xFF0000FF)
    private val baseYellow = Color(0xFFFFFF00)

    // ====================
    // 🎨 COLORS BY TYPE
    // ====================

    // Protanopia (Red Blind)
    private val protanopiaColors = listOf(
        Color(0xFF00B500),
        baseGreen,
        baseBlue,
        baseYellow
    )

    // Deuteranopia (Green Blind)
    private val deuteranopiaColors = listOf(
        baseRed,
        Color(0xFF8B4513),
        baseBlue,
        baseYellow
    )

    // Tritanopia (Blue-Yellow Blind)
    private val tritanopiaColors = listOf(
        baseRed,
        baseGreen,
        Color(0xFF800080),
        Color(0xFFFF7F00)
    )

    fun getColorScheme(type: Types): List<Color> {
        return when (type) {
            Types.PROTANOPIA -> protanopiaColors
            Types.DEUTERANOPIA -> deuteranopiaColors
            Types.TRITANOPIA -> tritanopiaColors
        }
    }
}