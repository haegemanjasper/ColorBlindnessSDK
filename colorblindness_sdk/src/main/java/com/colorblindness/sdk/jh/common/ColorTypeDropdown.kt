package com.colorblindness.sdk.jh.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.colorblindness.sdk.jh.models.Types

@Composable
fun ColorTypeDropdown(currentType: Types, onTypeSelected: (Types) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val dropdownWidth = 50.dp

    Box {
        Button(
            onClick = { expanded = true },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier.width(dropdownWidth)
        ) {
            Text(
                text = getTypeAbbreviation(currentType),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(dropdownWidth)
        ) {
            Types.entries.forEach { type ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = getTypeAbbreviation(type),
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    onClick = {
                        onTypeSelected(type)
                        expanded = false
                    }
                )
            }
        }
    }
}

fun getTypeAbbreviation(type: Types): String {
    return when (type) {
        Types.PROTANOPIA -> "P"
        Types.DEUTERANOPIA -> "D"
        Types.TRITANOPIA -> "T"
    }
}
