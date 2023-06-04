package com.rs.rsapplication.UI.Registration

import android.app.Application
import androidx.lifecycle.LiveData
import com.rs.rsapplication.Room.AppDatabase
import com.rs.rsapplication.Room.RegistrationDao
import com.rs.rsapplication.Room.RegistrationData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RegistrationRepository(application: Application) {

    private var registrationDao: RegistrationDao
    private var allStudents: LiveData<List<RegistrationData>>

    private val database = AppDatabase.getInstance(application)

    init {
        registrationDao = database.RegistrationDao()
        allStudents = registrationDao.getAllStudents()


    }
        fun getSpecifiedStudents(stnd:String):LiveData<List<RegistrationData>> {
          return  registrationDao.getStudentsbasedOnClass(stnd)
        }

          suspend fun insert(registrationData: RegistrationData):Long{
              return registrationDao.insert(registrationData)
        }

        fun getAllStudents(): LiveData<List<RegistrationData>> {
            return allStudents
        }

}