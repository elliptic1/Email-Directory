package com.tbse.domain.mapper

import com.tbse.data.models.EmailItemDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.models.EmailItemModel
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 */
class EmailItemMapper @Inject constructor(
) : ModelMapper<EmailItemDTO, EmailItemModel> {
    override fun map(input: EmailItemDTO): EmailItemModel {
        return EmailItemModel(
            name = input.name ?: "No name found",
            email = input.email ?: "No email found",
        )
    }
}
