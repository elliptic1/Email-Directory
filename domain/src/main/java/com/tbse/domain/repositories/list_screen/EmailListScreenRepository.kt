package com.tbse.domain.repositories.list_screen

import com.tbse.domain.models.EmailListModel

/**
 * Created by toddsmith on 1/15/23.
 */
interface EmailListScreenRepository {
    suspend fun getAllEmails(): EmailListModel

    suspend fun deleteItem(id: Int)

}