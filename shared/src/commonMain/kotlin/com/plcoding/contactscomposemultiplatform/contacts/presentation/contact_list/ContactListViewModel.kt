package com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list

import BaseViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.plcoding.contactscomposemultiplatform.contacts.data.SqlDelightContactsDataSource
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactValidator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContactListViewModel(
    private val sqlDelightContactsDataSource: SqlDelightContactsDataSource
) : BaseViewModel<ContactListContract.Event, ContactListContract.State, ContactListContract.Effect>() {

    var newContact: Contact? by mutableStateOf(null)
        private set

    override fun createInitialState(): ContactListContract.State {
        return ContactListContract.State()
    }

    override fun handleEvent(event: ContactListContract.Event) {
        when (event) {
            is ContactListContract.Event.DeleteContact -> {
                viewModelScope.launch {
                    setState {
                        copy(
                            isSelectedContactSheetOpen = false
                        )
                    }
                    sqlDelightContactsDataSource.deleteContact(event.contactId)
                    delay(300)
                    setState {
                        copy(
                            selectedContact = null
                        )
                    }
                }
            }

            ContactListContract.Event.DismissContact -> {
                viewModelScope.launch {
                    setState {
                        copy(
                            isSelectedContactSheetOpen = false,
                            isAddContactSheetOpen = false,
                            firstNameError = null,
                            lastNameError = null,
                            emailError = null,
                            phoneNumberError = null,
                        )
                    }
                    delay(300)

                }
            }

            ContactListContract.Event.DismissContact -> {
                viewModelScope.launch {
                    setState {
                        copy(
                            isSelectedContactSheetOpen = false,
                            isAddContactSheetOpen = false,
                            firstNameError = null,
                            lastNameError = null,
                            emailError = null,
                            phoneNumberError = null
                        )
                    }
                    delay(300L) // Animation delay
                    newContact = null
                    setState {
                        copy(
                            selectedContact = null
                        )
                    }
                }
            }

            is ContactListContract.Event.EditContact -> {
                setState {
                    copy(
                        selectedContact = null,
                        isAddContactSheetOpen = true,
                        isSelectedContactSheetOpen = false
                    )
                }
                newContact = event.contact
            }

            ContactListContract.Event.OnAddNewContactClick -> {
                setState {
                    copy(
                        isAddContactSheetOpen = true
                    )
                }
                newContact = Contact(
                    id = null,
                    firstName = "",
                    lastName = "",
                    email = "",
                    phoneNumber = "",
                    photo = null
                )
            }

            is ContactListContract.Event.OnEmailChanged -> {
                newContact = newContact?.copy(
                    email = event.value
                )
            }

            is ContactListContract.Event.OnFirstNameChanged -> {
                newContact = newContact?.copy(
                    firstName = event.value
                )
            }

            is ContactListContract.Event.OnLastNameChanged -> {
                newContact = newContact?.copy(
                    lastName = event.value
                )
            }

            is ContactListContract.Event.OnPhoneNumberChanged -> {
                newContact = newContact?.copy(
                    phoneNumber = event.value
                )
            }

            is ContactListContract.Event.OnPhotoPicked -> {
                newContact = newContact?.copy(
                    photo = event.bytes
                )
            }

            ContactListContract.Event.SaveContact -> {
                newContact?.let { contact ->
                    val result = ContactValidator.validateContact(contact)
                    val errors = listOfNotNull(
                        result.firstNameError,
                        result.lastNameError,
                        result.emailError,
                        result.phoneNumberError
                    )

                    if (errors.isEmpty()) {
                        setState {
                            copy(
                                isAddContactSheetOpen = false,
                                firstNameError = null,
                                lastNameError = null,
                                emailError = null,
                                phoneNumberError = null
                            )
                        }
                        viewModelScope.launch {
                            sqlDelightContactsDataSource.insertContact(contact)
                            delay(300L) // Animation delay
                            newContact = null
                        }
                    } else {
                        setState {
                            copy(
                                firstNameError = result.firstNameError,
                                lastNameError = result.lastNameError,
                                emailError = result.emailError,
                                phoneNumberError = result.phoneNumberError
                            )
                        }
                    }
                }
            }

            is ContactListContract.Event.SelectContact -> {
                setState {
                    copy(
                        selectedContact = event.contact,
                        isSelectedContactSheetOpen = true
                    )
                }
            }

            else -> Unit
        }
    }
}