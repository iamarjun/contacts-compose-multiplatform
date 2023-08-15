package com.plcoding.contactscomposemultiplatform

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
fun MainView() = App(
    darkTheme = isSystemInDarkTheme(),
    dynamicColors = true
)
