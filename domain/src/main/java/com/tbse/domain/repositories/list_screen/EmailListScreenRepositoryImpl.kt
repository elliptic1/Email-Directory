package com.tbse.domain.repositories.list_screen

import com.tbse.data.manager.DBManager
import com.tbse.data.models.EmailItemDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.models.EmailListModel

class EmailListScreenRepositoryImpl(
    private val emailsManager: DBManager,
    private val emailItemDTOMapper: ModelMapper<EmailItemDTO, EmailItemModel>,
) : EmailListScreenRepository {
    override suspend fun getAllEmails(): EmailListModel {
        return EmailListModel(
            emails = emailsManager
                .getAllEmails()
                .map { emailItemDTOMapper.map(it) }
        )
    }
}
