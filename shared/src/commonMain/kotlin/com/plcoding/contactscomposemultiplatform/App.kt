package com.plcoding.contactscomposemultiplatform

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun App() {
    MaterialTheme {
        Text(text = "Hello World ${Platform().name}")
    }
}