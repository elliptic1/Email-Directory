package com.tbse.data.di

import android.content.Context
import androidx.room.Room
import com.tbse.data.DBConstants
import com.tbse.data.EmailsDatabase
import com.tbse.data.entities.EmailItemEntity
import com.tbse.data.manager.DBManager
import com.tbse.data.manager.DBManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by toddsmith on 1/15/23.
 */
@Module(includes = [DBModelMapperModule::class])
@InstallIn(ViewModelComponent::class)
class DatabaseModule {

    @Provides
    fun providesDBManager(
        impl: DBManagerImpl,
    ): DBManager {
        return impl
    }

    @Provides
    fun providesEmailsDatabase(
        @ApplicationContext context: Context,
    ): EmailsDatabase {
        return Room
            .databaseBuilder(
                context = context,
                klass = EmailsDatabase::class.java,
                name = DBConstants.EMAIL_DATABASE,
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesEmailsDao(
        db: EmailsDatabase
    ) = db.emailsDao()

    @Provides
    fun providesEmailsItemEntity() = EmailItemEntity()

}