package com.plcoding.contactscomposemultiplatform.core.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase

actual class DatabaseDriver(private val context: Context) {
    actual fun create(): SqlDriver =
        AndroidSqliteDriver(ContactsDatabase.Schema, context, "contacts.db")
}