package com.rs.rsapplication.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RegistrationDao {
    @Insert
   suspend fun insert(registrationData: RegistrationData):Long
    @Update
    fun update(registrationData: RegistrationData)
    @Delete
    fun delete(registrationData: RegistrationData)



    @Query("select * from  registration_table")
    fun getAllStudents(): LiveData<List<RegistrationData>>

    @Query("select * from  registration_table where standard =:stand")
    fun getStudentsbasedOnClass(stand:String): LiveData<List<RegistrationData>>

}