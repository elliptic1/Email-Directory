package com.tbse.data.manager

import com.tbse.data.dao.EmailsDao
import com.tbse.data.mappers.EmailItemEntityMapper
import com.tbse.data.models.EmailItemDTO
import javax.inject.Inject

class DBManagerImpl @Inject constructor(
    private val emailsDao: EmailsDao,
    private val emailItemEntityMapper: EmailItemEntityMapper,
) : DBManager {
    override suspend fun getAllEmails(): List<EmailItemDTO> {
        return emailsDao
            .getAllEmails()
            .map {
                emailItemEntityMapper.map(it)
            }
    }
}
