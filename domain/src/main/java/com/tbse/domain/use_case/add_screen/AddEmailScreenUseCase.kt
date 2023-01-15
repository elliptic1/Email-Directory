package com.tbse.domain.use_case.add_screen

import com.tbse.data.resource.Resource
import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.models.EmailListModel
import com.tbse.domain.repositories.add_screen.AddEmailScreenRepository
import com.tbse.domain.repositories.list_screen.EmailListScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 */
class AddEmailScreenUseCase @Inject constructor(
    private val repo: AddEmailScreenRepository,
) {
    fun addEmail(
        email: EmailItemModel,
    ): Flow<Resource<out EmailListModel>> = flow {
        emit(Resource.Loading())
        try {
            repo.addEmail(email)
            emit(Resource.Success())
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "No error message"))
        }
    }
}
