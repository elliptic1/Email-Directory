package com.tbse.domain.repositories.add_screen

import com.tbse.data.manager.DBManager
import com.tbse.domain.models.EmailItemModel

class AddEmailScreenRepositoryImpl(
    private val emailsManager: DBManager,
) : AddEmailScreenRepository {
    override suspend fun addEmail(item: EmailItemModel) {
        emailsManager.addEmail(
            name = item.name,
            email = item.email,
        )
    }
}
