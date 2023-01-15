package com.tbse.domain.mapper

import com.tbse.data.models.EmailItemDTO
import com.tbse.data.models.EmailListDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.models.EmailListModel
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 */
class EmailListMapper @Inject constructor(
    private val itemMapper: ModelMapper<EmailItemDTO, EmailItemModel>,
) : ModelMapper<EmailListDTO, EmailListModel> {
    override fun map(input: EmailListDTO): EmailListModel {
        return EmailListModel(
            emails = input.emails.map {
                itemMapper.map(it)
            }
        )
    }
}
