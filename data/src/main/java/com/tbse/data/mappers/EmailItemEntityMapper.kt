package com.tbse.data.mappers

import com.tbse.data.ModelMapper
import com.tbse.data.entities.EmailItemEntity
import com.tbse.data.models.EmailItemDTO
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 *
 * This is to clean data from the database going into the domain layer
 */
class EmailItemEntityMapper @Inject constructor(
) : ModelMapper<EmailItemEntity, EmailItemDTO> {
    override fun map(input: EmailItemEntity): EmailItemDTO {
        return EmailItemDTO(
            name = input.name,
            email = input.email,
        )
    }
}
