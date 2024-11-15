package com.example.roomdatabase

import androidx.lifecycle.LiveData
import com.example.roomdatabase.dbEntity.Contact
import com.example.roomdatabase.dbRoom.ContactDAO

class Repository constructor(
    private val contactDAO: ContactDAO
) {
    fun addContact(contact: Contact){
        contactDAO.insert(contact)
    }

    fun getAllContact() : List<Contact>{
        return  contactDAO.getAllContacts()
    }

    fun deleteContact(contact: Contact){
        contactDAO.delete(contact)
    }

    fun getContact(id:Long){
        contactDAO.getContact(id)
    }
}