package com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list

import UiEffect
import UiEvent
import UiState
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact

object ContactListContract {

    sealed interface Event : UiEvent {
        data object OnAddNewContactClick : Event
        data object DismissContact : Event
        data class OnFirstNameChanged(val value: String) : Event
        data class OnLastNameChanged(val value: String) : Event
        data class OnEmailChanged(val value: String) : Event
        data class OnPhoneNumberChanged(val value: String) : Event
        class OnPhotoPicked(val bytes: ByteArray) : Event
        data object OnAddPhotoClicked : Event
        data object SaveContact : Event
        data class SelectContact(val contact: Contact) : Event
        data class EditContact(val contact: Contact) : Event
        data object DeleteContact : Event
    }

    sealed class Effect : UiEffect {

    }

    data class State(
        val contactsList: List<Contact> = emptyList(),
        val recentlyAddedContactsList: List<Contact> = emptyList(),
        val selectedContact: Contact? = null,
        val isAddContactSheetOpen: Boolean = false,
        val isSelectedContactSheetOpen: Boolean = false,
        val firstNameError: String? = null,
        val lastNameError: String? = null,
        val emailError: String? = null,
        val phoneNumberError: String? = null,
    ) : UiState
}