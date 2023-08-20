package com.plcoding.contactscomposemultiplatform.android.di

import com.plcoding.contactscomposemultiplatform.core.data.DatabaseDriver
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    single { DatabaseDriver(androidContext()).create() }
}