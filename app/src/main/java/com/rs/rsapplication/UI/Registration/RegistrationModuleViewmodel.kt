package com.rs.rsapplication.UI.Registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.rs.rsapplication.Room.RegistrationData
import com.rs.rsapplication.UI.Registration.RegistrationRepository
import kotlinx.coroutines.*

class RegistrationModuleViewmodel(app:Application):AndroidViewModel(app) {

    private val repository = RegistrationRepository(app)
    private val allStudents = repository.getAllStudents()



    suspend fun insert(registrationData: RegistrationData):Long =
        withContext(Dispatchers.IO) {
            repository.insert(registrationData)
        }



    fun getStudentsBasedonClass(stnd:String) :LiveData<List<RegistrationData>> {
        return repository.getSpecifiedStudents(stnd)
    }
    fun getAllNotes(): LiveData<List<RegistrationData>> {
        return allStudents
    }
}