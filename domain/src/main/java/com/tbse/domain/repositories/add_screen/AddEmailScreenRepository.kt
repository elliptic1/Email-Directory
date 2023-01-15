package com.tbse.domain.repositories.add_screen

import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.models.EmailListModel

/**
 * Created by toddsmith on 1/15/23.
 */
interface AddEmailScreenRepository {
    suspend fun addEmail(item: EmailItemModel)
}