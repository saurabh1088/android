package com.example.android_hello

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_hello.ui.theme.AndroidhelloTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private fun log(event: String) {
        Log.d("LIFECYCLE", "MainActivity → $event")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("onCreate")
        setContent {
            AndroidhelloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("Android")
                        Column {
                            Text(text = "Count: ${viewModel.count}")
                            Button(onClick = { viewModel.increment() }) {
                                Text("Increment")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Image(
                            painter = painterResource(id = R.drawable.android_logo),
                            contentDescription = "Android Logo",
                            modifier = Modifier
                                .height(200.dp)
                                .padding(8.dp)                // Outer spacing
                                .graphicsLayer(rotationZ = 10f) // Slight tilt
                                .clip(RoundedCornerShape(20.dp)) // Rounded corners
                                .border(2.dp, Color.Green, RoundedCornerShape(20.dp)) // Matching border
                        )

                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
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
    AndroidhelloTheme {
        Greeting("Android")
    }
}