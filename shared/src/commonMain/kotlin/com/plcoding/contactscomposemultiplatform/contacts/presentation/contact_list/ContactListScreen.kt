package com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.contactscomposemultiplatform.contacts.data.SqlDelightContactsDataSource
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.presentation.contact_list.components.ContactListItem
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.compose.getKoin

@Composable
fun ContactListScreen(
    modifier: Modifier,
    newContact: Contact?,
    state: ContactListContract.State,
    onEvent: (ContactListContract.Event) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier,
                onClick = { onEvent(ContactListContract.Event.OnAddPhotoClicked) },
                shape = RoundedCornerShape(20.dp),
                content = {
                    Icon(
                        imageVector = Icons.Rounded.PersonAdd,
                        contentDescription = "Add Contact",
                    )
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    modifier = Modifier,
                    text = "My Contacts ${state.contactsList.size}"
                )
            }

            items(state.contactsList) {
                ContactListItem(modifier = Modifier, contact = it)
            }
        }

    }
}