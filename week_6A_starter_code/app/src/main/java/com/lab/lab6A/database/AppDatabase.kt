package com.lab.lab6A.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.coroutines.runBlocking

@Database(entities = [NumberData::class], exportSchema = false, version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun numberDao(): NumberDao

    companion object {
        private val DATABASE_NAME = "number_database"
        // marking the instance as volatile to ensure atomic access to the variable
        @Volatile
        private var db_instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return db_instance ?: synchronized(this) {
                db_instance ?: buildDatabase(context).also { db_instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                // Wipes and rebuilds instead of migrating if no Migration object specified.
                .fallbackToDestructiveMigration()
                .addCallback(sRoomDatabaseCallback)
                .build()
        }

        /**
         * Override the onOpen method to populate the database.
         * For this sample, we clear the database every time it is created or opened.
         *
         * If you want to populate the database only when the database is created for the 1st time,
         * override RoomDatabase.Callback()#onCreate
         */
        private val sRoomDatabaseCallback: RoomDatabase.Callback = object : Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // do any init operation here - e.g. seed the database with data
            }
        }
    }
}