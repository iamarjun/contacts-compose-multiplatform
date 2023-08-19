package com.plcoding.contactscomposemultiplatform

import com.plcoding.contactscomposemultiplatform.di.appModule
import org.koin.core.context.startKoin

fun initDi() {
    startKoin {
        modules(appModule())
    }
}