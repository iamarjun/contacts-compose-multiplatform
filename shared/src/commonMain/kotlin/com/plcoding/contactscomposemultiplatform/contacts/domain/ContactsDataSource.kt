package com.plcoding.contactscomposemultiplatform.contacts.domain

import kotlinx.coroutines.flow.Flow

interface ContactsDataSource {

    fun getContacts(): Flow<List<Contact>>
    fun getRecentContacts(limit: Int): Flow<List<Contact>>

    suspend fun insertContact(contact: Contact)

    suspend fun deleteContact(id: Long)
}