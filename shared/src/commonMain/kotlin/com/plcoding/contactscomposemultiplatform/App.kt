package com.plcoding.contactscomposemultiplatform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list.ContactListContract
import com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list.ContactListScreen
import com.plcoding.contactscomposemultiplatform.core.prensentation.ContactsTheme

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean,
) {
    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColors = dynamicColors
    ) {
        ContactListScreen(
            modifier = Modifier,
            newContact = null,
            state = ContactListContract.State(
                contactsList = (0..50).map {
                    Contact(
                        it.toLong(),
                        "$it",
                        "${it + it}",
                        "${it}.69@gmail.com",
                        "${it * 100000000}",
                        photo = null
                    )
                },
                recentlyAddedContactsList = listOf(),
                selectedContact = null,
                isAddContactSheetOpen = false,
                isSelectedContactSheetOpen = false,
                firstNameError = null,
                lastNameError = null,
                emailError = null,
                phoneNumberError = null
            ), onEvent = {})
    }
}