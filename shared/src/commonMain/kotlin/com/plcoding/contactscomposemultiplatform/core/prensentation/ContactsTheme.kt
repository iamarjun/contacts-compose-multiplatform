package com.plcoding.contactscomposemultiplatform.core.prensentation

import androidx.compose.runtime.Composable

@Composable
expect fun ContactsTheme(
    darkTheme: Boolean,
    dynamicColors: Boolean,
    content: @Composable () -> Unit
)