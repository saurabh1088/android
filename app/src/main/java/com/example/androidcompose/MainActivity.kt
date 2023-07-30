package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {

    /*
     onCreate below is the entry point for Android app. Kotlin programs have main() function as the
     entry point. In case of Android apps onCreate() function fills the role of entry point.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO: Fix this
                    Greeting("Android")
                    Greeting("Hello World!")
                }
            }
        }
    }
}

/*
@Composable annotation tells Kotlin compiler that this function will be used by Jetpack Compose to
generate some UI as declared by it.
One interesting point about functions annotated with @Composable is that the naming convention followed
is such that the names are capitalized.

Functions annotated with @Composable :
- Names are capitalized
- Can't return anything
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidComposeTheme {
        Greeting("Android")
    }
}