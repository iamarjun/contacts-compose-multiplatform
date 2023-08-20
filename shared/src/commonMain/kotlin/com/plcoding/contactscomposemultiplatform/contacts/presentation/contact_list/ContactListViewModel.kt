package com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list

import BaseViewModel
import com.plcoding.contactscomposemultiplatform.contacts.data.SqlDelightContactsDataSource

class ContactListViewModel(
    private val sqlDelightContactsDataSource: SqlDelightContactsDataSource
) : BaseViewModel<ContactListContract.Event, ContactListContract.State, ContactListContract.Effect>() {
    override fun createInitialState(): ContactListContract.State {
        return ContactListContract.State()
    }

    override fun handleEvent(event: ContactListContract.Event) {
        when (event) {
            ContactListContract.Event.DeleteContact -> {}
            ContactListContract.Event.DismissContact -> {}
            is ContactListContract.Event.EditContact -> {}
            ContactListContract.Event.OnAddNewContactClick -> {}
            ContactListContract.Event.OnAddPhotoClicked -> {}
            is ContactListContract.Event.OnEmailChanged -> {}
            is ContactListContract.Event.OnFirstNameChanged -> {}
            is ContactListContract.Event.OnLastNameChanged -> {}
            is ContactListContract.Event.OnPhoneNumberChanged -> {}
            is ContactListContract.Event.OnPhotoPicked -> {}
            ContactListContract.Event.SaveContact -> {}
            is ContactListContract.Event.SelectContact -> {}
        }
    }
}