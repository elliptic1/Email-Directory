package com.tbse.domain.di

import android.view.Display.Mode
import com.tbse.data.models.EmailItemDTO
import com.tbse.data.models.EmailListDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.mapper.EmailItemMapper
import com.tbse.domain.mapper.EmailListMapper
import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.models.EmailListModel
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
    abstract fun bindsEmailListMapper(
        impl: EmailListMapper
    ): ModelMapper<EmailListDTO, EmailListModel>

    @Binds
    abstract fun bindsEmailItemMapper(
        impl: EmailItemMapper
    ): ModelMapper<EmailItemDTO, EmailItemModel>
    
}