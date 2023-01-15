package com.tbse.domain.di

import com.tbse.data.manager.DBManager
import com.tbse.data.models.EmailItemDTO
import com.tbse.domain.ModelMapper
import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.repositories.add_screen.AddEmailScreenRepository
import com.tbse.domain.repositories.add_screen.AddEmailScreenRepositoryImpl
import com.tbse.domain.repositories.list_screen.EmailListScreenRepository
import com.tbse.domain.repositories.list_screen.EmailListScreenRepositoryImpl
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
        emailsManager: DBManager,
        mapper: ModelMapper<EmailItemDTO, EmailItemModel>
    ): EmailListScreenRepository {
        return EmailListScreenRepositoryImpl(emailsManager, mapper)
    }

    @Provides
    fun providesAddEmailScreenRepository(
        emailsManager: DBManager,
    ): AddEmailScreenRepository {
        return AddEmailScreenRepositoryImpl(emailsManager)
    }

}
