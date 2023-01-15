package com.tbse.domain.repositories

import com.tbse.domain.models.EmailListModel

/**
 * Created by toddsmith on 1/15/23.
 */
interface EmailListScreenRepository {
    fun getAllEmails(): EmailListModel
}