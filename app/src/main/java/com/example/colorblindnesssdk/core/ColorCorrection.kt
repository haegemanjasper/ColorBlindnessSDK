package com.example.colorblindnesssdk.core

import android.graphics.Color

object ColorCorrection {

    fun correctProtanopia(color: Int): Int {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        val correctedRed = (red * 0.56667 + green * 0.43333).toInt()
        val correctedGreen = (red * 0.55833 + green * 0.44167).toInt()

        return Color.rgb(correctedRed.coerceIn(0, 255), correctedGreen.coerceIn(0, 255), blue)
    }

    fun correctDeuteranopia(color: Int): Int {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        val correctedRed = (red * 0.625 + green * 0.375).toInt()
        val correctedGreen = (red * 0.7 + green * 0.3).toInt()

        return Color.rgb(correctedRed.coerceIn(0, 255), correctedGreen.coerceIn(0, 255), blue)
    }

    fun correctTritanopia(color: Int): Int {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        val correctedBlue = (red * 0.16667 + blue * 0.83333).toInt()
        val correctedGreen = (green * 0.66667 + blue * 0.33333).toInt()

        return Color.rgb(red, correctedGreen.coerceIn(0, 255), correctedBlue.coerceIn(0, 255))
    }
}