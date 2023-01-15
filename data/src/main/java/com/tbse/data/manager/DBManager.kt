package com.tbse.data.manager

import com.tbse.data.models.EmailItemDTO

/**
 * Created by toddsmith on 1/15/23.
 */
interface DBManager {
    suspend fun getAllEmails(): List<EmailItemDTO>

    suspend fun addEmail(name: String, email: String)
}