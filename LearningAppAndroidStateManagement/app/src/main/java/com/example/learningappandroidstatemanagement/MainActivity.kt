package com.example.learningappandroidstatemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.learningappandroidstatemanagement.ui.theme.LearningAppAndroidStateManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningAppAndroidStateManagementTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        GreetingWithState()
                        GreetingStateless()
                        GreetingWithStateSurvival()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingWithState() {
    // 1. Define the State
    // 'remember' keeps the value during recomposition (re-drawing)
    // 'mutableStateOf' makes the variable "observable" by Compose
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 2. The UI reads the State
        Text(text = if (name.isEmpty()) "Hello, Stranger!" else "Hello, $name!")

        Spacer(modifier = Modifier.height(8.dp))

        // 3. The Event updates the State
        TextField(
            value = name,
            onValueChange = { newText -> name = newText }, // Event trigger
            label = { Text("Enter your name (Stateful)") }
        )
    }
}

@Composable
fun GreetingStateless() {
    var name = ""

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 2. The UI reads the State
        Text(text = if (name.isEmpty()) "Hello, Stranger!" else "Hello, $name!")

        Spacer(modifier = Modifier.height(8.dp))

        // 3. The Event updates the State
        TextField(
            value = name,
            onValueChange = { newText -> name = newText }, // Event trigger
            label = { Text("Enter your name (Stateless)") }
        )
    }
}

@Composable
fun GreetingWithStateSurvival() {
    // 1. Define the State
    // 'rememberSaveable' keeps the value during recomposition
    // AND survives configuration changes (e.g. screen rotation)
    var name by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 2. The UI reads the State
        Text(text = if (name.isEmpty()) "Hello, Stranger!" else "Hello, $name!")

        Spacer(modifier = Modifier.height(8.dp))

        // 3. The Event updates the State
        TextField(
            value = name,
            onValueChange = { newText -> name = newText },
            label = { Text("Enter your name (Stateful + Saveable)") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningAppAndroidStateManagementTheme {
        Greeting("Android")
    }
}