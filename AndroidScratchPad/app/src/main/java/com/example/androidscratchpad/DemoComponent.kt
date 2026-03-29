package com.example.androidscratchpad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class DemoComponent(
    val name: String,
    val content: @Composable () -> Unit
)

val components = listOf(
    DemoComponent("Badge") { OotbBadge() },
    DemoComponent("Buttons") {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OotbButton()
            OotbIconButton()
            OotbFilledTonalButton()
            OotbOutlinedButton()
            OotbElevatedButton()
            OotbTextButton()
            MyCustomButton()
        }
    },
    DemoComponent("Text Input") { OotbTextField() },
    DemoComponent("Selection Controls") {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                OotbCheckbox()
                Text("Checkbox")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                OotbSwitch()
                Text("Switch")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                OotbRadioButton()
                Text("Radio Button")
            }
        }
    },
    DemoComponent("Range Selection") { OotbSlider() },
    DemoComponent("Progress Indicators") {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            OotbCircularProgressIndicator()
            OotbLinearProgressIndicator()
        }
    },
    DemoComponent("Dialogs & Feedback") {
        var showDialog by remember { mutableStateOf(false) }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Button(
                onClick = { showDialog = true }
            ) {
                Text("Show Dialog")
            }

            // These usually contain buttons that trigger the Dialog/Snackbar
            OotbAlertDialog(
                showDialog = showDialog,
                onDismiss = { showDialog = false }
            )
            OotbSnackbar()
        }
    }
)
