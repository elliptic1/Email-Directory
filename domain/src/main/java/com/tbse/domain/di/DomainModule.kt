package com.tbse.domain.di

import com.tbse.data.models.EmailListDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.models.EmailListModel
import com.tbse.domain.repositories.EmailListScreenRepository
import com.tbse.domain.repositories.EmailListScreenRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by toddsmith on 1/15/23.
 */
@Module(includes = [ModelMapperModule::class])
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesEmailListScreenRepository(
        mapper: ModelMapper<EmailListDTO, EmailListModel>
    ): EmailListScreenRepository {
        return EmailListScreenRepositoryImpl(mapper)
    }

}
