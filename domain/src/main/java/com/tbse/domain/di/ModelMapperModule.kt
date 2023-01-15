package com.tbse.domain.di

import com.tbse.data.entities.EmailItemEntity
import com.tbse.data.models.EmailItemDTO
import com.tbse.domain.ModelMapper
import com.tbse.data.mappers.EmailItemEntityMapper
import com.tbse.domain.mapper.EmailItemMapper
import com.tbse.domain.models.EmailItemModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by toddsmith on 1/15/23.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class ModelMapperModule {

    @Binds
    abstract fun bindsEmailItemMapper(
        impl: EmailItemMapper
    ): ModelMapper<EmailItemDTO, EmailItemModel>

}