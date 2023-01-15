package com.tbse.domain.repositories

import com.tbse.data.models.EmailListDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.models.EmailListModel

class EmailListScreenRepositoryImpl(
    private val emailListModelMapper: ModelMapper<EmailListDTO, EmailListModel>
) : EmailListScreenRepository {
    override fun getAllEmails(): EmailListModel {
        TODO("Not yet implemented")
    }
}