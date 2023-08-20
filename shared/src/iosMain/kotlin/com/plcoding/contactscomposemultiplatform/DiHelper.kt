package com.plcoding.contactscomposemultiplatform

import com.plcoding.contactscomposemultiplatform.di.appModule
import com.plcoding.contactscomposemultiplatform.di.iOSModule
import org.koin.core.context.startKoin

fun initDi() {
    startKoin {
        modules(iOSModule)
        modules(appModule())
    }
}