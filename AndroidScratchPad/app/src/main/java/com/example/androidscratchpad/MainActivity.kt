package com.example.androidscratchpad

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import com.example.androidscratchpad.ui.theme.AndroidScratchPadTheme
import com.example.androidscratchpad.DemoComponent

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidScratchPadTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Cyan,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("My Scratch-pad App")
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { println("FAB Clicked") }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add"
                            )
                        }
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(components) { component ->
                            // Wrap each demo in a Card for better visual "cleanup"
                            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = component.name,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                                    component.content()
                                }
                            }
                        }
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
fun OotbFilledTonalButton() {
    FilledTonalButton(
        onClick = {
            println("Filled Tonal Button Clicked")
        },
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Filled Tonal Button")
    }
}

@Composable
fun OotbOutlinedButton() {
    OutlinedButton(
        onClick = {
            println("Outlined Button Clicked")
        },
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Outlined Button")
    }
}

@Composable
fun OotbElevatedButton() {
    ElevatedButton(
        onClick = {
            println("Elevated Button Clicked")
        },
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Elevated Button")
    }
}

@Composable
fun OotbTextButton() {
    TextButton(
        onClick = {
            println("Text Button Clicked")
        },
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Text Button")
    }
}

@Composable
fun MyCustomButton() {
    CustomButton(
        text = "Custom Button",
        onClick = {
            println("Custom Button Clicked")
        },
        modifier = Modifier.padding(16.dp),
        enabled = true
    )
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = if (enabled) Color(0xFF6200EE) else Color.Gray,
        shadowElevation = 6.dp
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
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
fun OotbCircularProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OotbLinearProgressIndicator() {
    LinearProgressIndicator(
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun OotbAlertDialog() {
    AlertDialog(
        onDismissRequest = {
            println("Alert Dialog Dismissed")
        },
        title = {
            Text(text = "Alert Dialog")
        },
        text = {
            Text(text = "This is an alert dialog")
        },
        confirmButton = {
            Button(
                onClick = {
                    println("Alert Dialog Confirmed")
                }
            ) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    println("Alert Dialog Dismissed")
                }
            ) {
                Text(text = "Dismiss")
            }
        }
    )
}

@Composable
fun OotbSnackbar() {
    Snackbar(
        modifier = Modifier.padding(16.dp),
        action = {
            Button(
                onClick = {
                    println("Snackbar Action Clicked")
                }
            ) {
                Text(text = "Action")
            }
        }
    ) {
        Text(text = "This is a Snackbar message")
    }
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