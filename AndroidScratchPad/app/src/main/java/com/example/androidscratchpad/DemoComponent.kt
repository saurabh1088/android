package com.example.androidscratchpad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

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
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // These usually contain buttons that trigger the Dialog/Snackbar
            OotbAlertDialog()
            OotbSnackbar()
        }
    }
)
