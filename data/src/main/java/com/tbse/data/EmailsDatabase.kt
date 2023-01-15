package com.tbse.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tbse.data.dao.EmailsDao
import com.tbse.data.entities.EmailItemEntity

/**
 * Created by toddsmith on 1/15/23.
 */
@Database(entities = [EmailItemEntity::class], version = 1)
abstract class EmailsDatabase : RoomDatabase() {
    abstract fun emailsDao(): EmailsDao
}
