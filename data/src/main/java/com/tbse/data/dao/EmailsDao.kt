package com.tbse.data.dao

import androidx.room.*
import com.tbse.data.DBConstants
import com.tbse.data.entities.EmailItemEntity

/**
 * Created by toddsmith on 1/15/23.
 */
@Dao
interface EmailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmail(emailEntity: EmailItemEntity)

    @Query("SELECT * FROM ${DBConstants.EMAIL_TABLE} ORDER BY emailItemId DESC")
    suspend fun getAllEmails(): List<EmailItemEntity>

    @Delete
    suspend fun deleteItem(emailEntity: EmailItemEntity)

}