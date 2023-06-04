package com.rs.rsapplication.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [RegistrationData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun RegistrationDao():RegistrationDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AppDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java, "reg_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            return instance!!
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
              //  populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: AppDatabase) {
            val registrationDao = db.RegistrationDao()
            GlobalScope.launch {
                registrationDao.insert(RegistrationData(1,"jay","Senapati","msenapati2@gmail.com","8309096963","4","Male","CBSE"))
                registrationDao.insert(RegistrationData(2,"mruty","Senapati","msenapati2@gmail.com","8309096963","4","Male","CBSE"))
                registrationDao.insert(RegistrationData(3,"sam","das","samsa2@gmail.com","8309096963","4","Male","CBSE"))
                registrationDao.insert(RegistrationData(4,"raj","barik","rajbaril@gmail.com","8309096963","4","Male","CBSE"))
            }
        }
    }
}