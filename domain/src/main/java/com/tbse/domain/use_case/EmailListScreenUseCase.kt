package com.tbse.domain.use_case

import com.tbse.data.resource.Resource
import com.tbse.domain.models.EmailListModel
import com.tbse.domain.repositories.EmailListScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 */
class EmailListScreenUseCase @Inject constructor(
    private val repo: EmailListScreenRepository,
) {
    operator fun invoke(): Flow<Resource<out EmailListModel>> = flow {

    }
}