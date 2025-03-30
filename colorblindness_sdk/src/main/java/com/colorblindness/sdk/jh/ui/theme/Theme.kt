package com.colorblindness.sdk.jh.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.colorblindness.sdk.jh.models.Types

@Composable
fun SdkTheme(
    type: Types,
    colorScheme: ColorScheme? = null,
    content: @Composable () -> Unit
) {
    val colorSchemeProvider = remember { ColorSchemeProvider() }
    val usedColorScheme = colorScheme ?: colorSchemeProvider.getColorScheme(type)

    MaterialTheme(
        colorScheme = usedColorScheme,
        content = content
    )
}