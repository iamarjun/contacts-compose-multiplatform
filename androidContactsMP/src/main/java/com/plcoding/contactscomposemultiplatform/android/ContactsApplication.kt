package com.plcoding.contactscomposemultiplatform.android

import android.app.Application
import com.plcoding.contactscomposemultiplatform.android.di.androidModule
import com.plcoding.contactscomposemultiplatform.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ContactsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ContactsApplication)
            androidLogger()
            modules(appModule() + androidModule)
        }
    }
}