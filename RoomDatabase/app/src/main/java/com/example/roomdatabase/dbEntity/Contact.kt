package com.example.roomdatabase.dbEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contact(
    @ColumnInfo(name = "contacts_id")
    @PrimaryKey(autoGenerate = true)
     var id: Long= 0,
    @ColumnInfo(name = "contacts_name")
    var name:String,
    @ColumnInfo(name = "contacts_email")
    var email:String
){

    fun setEmail(email: String){
        this.email = email
    }

    fun setName(name: String){
        this.name = name
    }
}