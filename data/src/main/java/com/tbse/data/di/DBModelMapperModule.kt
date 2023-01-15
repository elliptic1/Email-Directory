package com.tbse.data.di

import com.tbse.data.ModelMapper
import com.tbse.data.entities.EmailItemEntity
import com.tbse.data.mappers.EmailItemEntityMapper
import com.tbse.data.models.EmailItemDTO
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by toddsmith on 1/15/23.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class DBModelMapperModule {

    @Binds
    abstract fun bindsEmailItemEntityMapper(
        impl: EmailItemEntityMapper
    ): ModelMapper<EmailItemEntity, EmailItemDTO>

}
