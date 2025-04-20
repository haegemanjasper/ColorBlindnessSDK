package com.colorblindness.sdk.jh.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.colorblindness.sdk.jh.models.Types

@Composable
fun SdkTheme(
    type: Types,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorSchemeProvider = remember { ColorSchemeProvider() }
    val colorScheme: ColorScheme = colorSchemeProvider.getColorScheme(type, isDarkTheme)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}