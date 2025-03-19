package com.colorblindness.sdk.jh.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.colorblindness.sdk.jh.models.Types

@Composable
fun SdkTheme(
    type: Types,
    content: @Composable () -> Unit
) {
    val colorSchemeProvider = ColorSchemeProvider()
    val colorScheme = colorSchemeProvider.getColorScheme(type)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}