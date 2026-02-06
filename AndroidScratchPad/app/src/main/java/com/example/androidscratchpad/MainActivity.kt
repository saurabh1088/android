package com.example.androidscratchpad

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidscratchpad.ui.theme.AndroidScratchPadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidScratchPadTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Cyan
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    ) {
                        OotbBadge()
                        OotbButton()
                        OotbIconButton()
                        OotbTextField()
                        OotbCheckbox()
                        OotbSwitch()
                        OotbSlider()
                        OotbRadioButton()
                    }
                }
            }
        }
    }
}

@Composable
fun OotbText() {
    Text(
        text = "Hello Android!",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OotbBox() {
    Box {
        Text(
            text = "Hello!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Android!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun OotbColumnRow() {
    Column() {
        Text(
            text = "This is Android!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Row() {
            Text(
                text = "Hell",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Yeah",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun OotbCard() {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Text(
            text = "This is Android!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun OotbBadge() {
    Column() {
        Badge {
            Text(
                text = "This!",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(16.dp)
            )
        }
        Row() {
            Badge {
                Text(
                    text = "is",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Badge {
                Text(
                    text = "Android!",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun OotbButton() {
    Button(
        onClick = {
            println("Button Clicked")
        },
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Button Click")
    }
}

@Composable
fun OotbIconButton() {
    IconButton(
        onClick = {
            println("Icon Button Clicked")
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite"
        )
    }
}

@Composable
fun OotbTextField() {
    TextField(
        value = "",
        onValueChange = {
            println("Text Field Changed")
        },
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun OotbCheckbox() {
    // TODO: Updated to add true state, at present this remains unchecked
    Checkbox(
        checked = false,
        onCheckedChange = {
            println("Checkbox Changed")
        },
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OotbSwitch() {
    // TODO: Updated to add true state, at present this remains unchecked
    // TODO: Add a title to it, this might need to wrap this in a Row
    Switch(
        checked = false,
        onCheckedChange = {
            println("Switch Changed")
        },
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OotbSlider() {
    Slider(
        value = 0f,
        onValueChange = {
            println("Slider Changed")
        },
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OotbRadioButton() {
    RadioButton(
        selected = false,
        onClick = {
            println("Radio Button Changed")
        },
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidScratchPadTheme {
        Greeting("Android")
    }
}