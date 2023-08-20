package com.plcoding.contactscomposemultiplatform.core.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase

actual class DatabaseDriver {
    actual fun create(): SqlDriver = NativeSqliteDriver(ContactsDatabase.Schema, "contacts.db")
}