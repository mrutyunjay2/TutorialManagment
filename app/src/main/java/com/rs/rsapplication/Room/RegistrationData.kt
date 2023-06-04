package com.rs.rsapplication.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registration_table")
data class RegistrationData(@PrimaryKey(autoGenerate = true) val id: Int,
                            @ColumnInfo(name = "firstName") val firstName: String?,
                            @ColumnInfo(name = "lastName") val lastName: String?,
                            @ColumnInfo(name = "email") val email: String?,
                            @ColumnInfo(name = "mobNo") val mobNo: String?,
                            @ColumnInfo(name = "standard") val standard: String?,
                            @ColumnInfo(name = "gender") val gender: String?,
                            @ColumnInfo(name = "boardType") val boardType: String="CBSE")
{
    constructor(
        firstName: String,
        lastName: String,
        email: String,
        mobNo: String,
        standard: String,
        gender: String,
        boardType: String) :
            this(0,firstName,lastName,email,mobNo,standard,gender,boardType)
}
