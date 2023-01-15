package com.tbse.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tbse.data.DBConstants

/**
 * Created by toddsmith on 1/15/23.
 */
@Entity(tableName = DBConstants.EMAIL_TABLE)
data class EmailItemEntity(
    @PrimaryKey(autoGenerate = true)
    val emailItemId: Int = 0,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "email")
    val email: String = "",
)
