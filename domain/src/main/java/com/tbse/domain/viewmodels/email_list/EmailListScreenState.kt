package com.tbse.domain.viewmodels.email_list

import com.tbse.domain.models.EmailItemModel

/**
 * Created by toddsmith on 1/15/23.
 */
sealed class EmailListScreenState {
    object Loading : EmailListScreenState()

    object Update : EmailListScreenState()

    data class ReceivedEmailList(
        val emailList: List<EmailItemModel>
    ) : EmailListScreenState()

    data class Error(
        val error: Exception
    ) : EmailListScreenState()
}
