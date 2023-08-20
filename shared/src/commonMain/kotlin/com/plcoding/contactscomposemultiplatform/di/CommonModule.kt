package com.plcoding.contactscomposemultiplatform.di

import com.plcoding.contactscomposemultiplatform.contacts.data.SqlDelightContactsDataSource
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val commonModule = module {
    single(named("DefaultDispatcher")) { Dispatchers.Default }
    single(named("MainDispatcher")) { Dispatchers.Main }
    single(named("UnconfinedDispatcher")) { Dispatchers.Unconfined }
    single { ContactsDatabase(driver = get()) }
    single { SqlDelightContactsDataSource(get(), get(named("DefaultDispatcher"))) }
}
