package com.example.roomdatabase.dbRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.dbEntity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase() : RoomDatabase() {
    abstract fun getContactDAO(): ContactDAO

    companion object {
        //  @Volatile private var instance : ContactDatabase? = null
        @Volatile
        private var dbInstance: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contacts_db"
                ).fallbackToDestructiveMigration().build()
//            ).also { dbInstance = it }
            }
            return dbInstance!!
        }
    }

//            if (dbInstance == null) {
//                dbInstance ?: synchronized(this) {
//                    dbInstance ?: Companion.dbInstance!!

}