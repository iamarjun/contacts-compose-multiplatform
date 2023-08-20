package com.plcoding.contactscomposemultiplatform.contacts.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactsDataSource
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightContactsDataSource(
    db: ContactsDatabase,
    private val defaultDispatcher: CoroutineDispatcher
) : ContactsDataSource {

    private val queries = db.contactQueries
    override fun getContacts(): Flow<List<Contact>> {
        return queries
            .getContacts()
            .asFlow()
            .mapToList(defaultDispatcher)
            .map { it.map { it.toContact() } }
    }

    override fun getRecentContacts(limit: Int): Flow<List<Contact>> {
        return queries
            .getRecentContact(limit.toLong())
            .asFlow()
            .mapToList(defaultDispatcher)
            .map { it.map { it.toContact() } }
    }

    override suspend fun insertContact(contact: Contact) {
        queries.inserContact(
            id = contact.id,
            firstName = contact.firstName,
            lastName = contact.lastName,
            phoneNumber = contact.phoneNumber,
            email = contact.email,
            createdAt = Clock.System.now().toEpochMilliseconds(),
            imagePath = null
        )
    }

    override suspend fun deleteContact(id: Long) {
        queries.deleteContact(id = id)
    }
}