package com.example.roomdatabase.dbEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
class ContactModel(
    @ColumnInfo(name = "contacts_id")
    @PrimaryKey(autoGenerate = true)
    private var id:String,
    @ColumnInfo(name = "contacts_name")
    private var name:String,
    @ColumnInfo(name = "contacts_email")
    private var email:String
) {
//    constructor(id: String, name: String,email: String){
//        this.email= email
//        this.id = id
//        this.name = name
//    }
//    }

}