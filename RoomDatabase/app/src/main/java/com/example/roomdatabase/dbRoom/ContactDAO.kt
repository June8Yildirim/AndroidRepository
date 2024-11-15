package com.example.roomdatabase.dbRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.dbEntity.Contact

@Dao
interface ContactDAO {

    @Query("SELECT * FROM contacts_table")
    fun getAllContacts(): List<Contact>

    @Insert
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

    @Query("UPDATE contacts_table SET contacts_name = :name where contacts_id = :id ")
    fun updateContactName(id: String, name: String): Contact

    @Query("SELECT * FROM contacts_table where contacts_id = :id ")
    fun getContact(id: Long): Contact

}