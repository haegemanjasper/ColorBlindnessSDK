package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.colorblindness.sdk.jh.models.Types
import com.colorblindness.sdk.jh.ui.theme.ColorSchemeProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var selectedType by remember { mutableStateOf(Types.PROTANOPIA) }
    val colorSchemeProvider = ColorSchemeProvider()
    val colors = colorSchemeProvider.getColorScheme(selectedType)

    var dropdownExpanded by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Box(
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Text(
                    text = "Select Type ▼",
                    color = colors.onPrimary,
                    modifier = Modifier
                        .clickable { dropdownExpanded = true }
                        .background(colors.primary, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                )

                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false }
                ) {
                    Types.values().forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type.name) },
                            onClick = {
                                selectedType = type
                                dropdownExpanded = false
                            }
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Red", color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.padding(8.dp))
                Box(modifier = Modifier.size(120.dp).background(colors.primary))

                Spacer(modifier = Modifier.height(16.dp))

                Text("Green", color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.padding(8.dp))
                Box(modifier = Modifier.size(120.dp).background(colors.secondary))

                Spacer(modifier = Modifier.height(16.dp))

                Text("Blue", color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.padding(8.dp))
                Box(modifier = Modifier.size(120.dp).background(colors.tertiary))
            }
        }
    }
}
