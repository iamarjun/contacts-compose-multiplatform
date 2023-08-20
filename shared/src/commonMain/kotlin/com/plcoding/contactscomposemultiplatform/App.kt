package com.plcoding.contactscomposemultiplatform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.plcoding.contactscomposemultiplatform.contacts.data.SqlDelightContactsDataSource
import com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list.ContactListScreen
import com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list.ContactListViewModel
import com.plcoding.contactscomposemultiplatform.core.prensentation.ContactsTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.compose.getKoin

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean,
) {
    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColors = dynamicColors
    ) {
        val sqlDelightContactsDataSource = getKoin().get<SqlDelightContactsDataSource>()
        val viewModel = getViewModel(
            key = "contact-list-screen",
            factory = viewModelFactory {
                ContactListViewModel(sqlDelightContactsDataSource = sqlDelightContactsDataSource)
            }
        )
        val state by viewModel.uiState.collectAsState()
        ContactListScreen(
            modifier = Modifier,
            newContact = null,
            state = state,
            onEvent = viewModel::handleEvent
        )
    }
}