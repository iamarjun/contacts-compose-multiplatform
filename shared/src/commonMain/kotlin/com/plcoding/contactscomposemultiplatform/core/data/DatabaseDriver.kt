package com.plcoding.contactscomposemultiplatform.core.data

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriver {
    fun create(): SqlDriver
}