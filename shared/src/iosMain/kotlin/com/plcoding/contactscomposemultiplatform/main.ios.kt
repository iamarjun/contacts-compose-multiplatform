package com.plcoding.contactscomposemultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController() = ComposeUIViewController {
    App(
        darkTheme = UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark,
        dynamicColors = true
    )
}