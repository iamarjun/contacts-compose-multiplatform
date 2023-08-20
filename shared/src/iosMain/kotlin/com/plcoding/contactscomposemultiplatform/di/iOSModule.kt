package com.plcoding.contactscomposemultiplatform.di

import com.plcoding.contactscomposemultiplatform.core.data.DatabaseDriver
import org.koin.dsl.module

val iOSModule = module {
    single { DatabaseDriver().create() }
}