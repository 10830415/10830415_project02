package com.example.trial_sai

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DB(context:Context) : SQLiteOpenHelper(context, "ProjectDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL( "CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT,PASSWORD TEXT)")
        db?.execSQL( "INSERT INTO USERS(USERNAME,EMAIL,PASSWORD) VALUES('editTextTextEmailAddress','editTextTextEmailAddress2','editTextTextPassword')")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       db?.execSQL(" drop table if exists users")
        onCreate(db)
    }

    fun insertData(username: String?, email: String?, password: String?) : Boolean{
        val db = this.writableDatabase
        var cv = contentValuesOf()
        cv.put("username", username)
        cv.put("email", email)
        cv.put("password", password)

        val rowId = db.insert("Users", null, cv)
        return rowId>0
    }


    fun checkUser(username: String?): Boolean {
        val db = this.readableDatabase
        val cs = db.query("users", arrayOf("username", "email", "password"),"username = ?" , arrayOf(username), null, null, null)
        val cc = cs.count
        cs.close()
        db.close()

        if(cc > 0)
        {
            return true
        }

        return false

    }

    fun checkUserPassword(username: String?, password: String?): Boolean {
        val db = this.readableDatabase
        val cs = db.query("users", arrayOf("username", "email", "password"),"username = ? and password = ?" ,
            arrayOf(username, password), null, null, null)
        val cc = cs.count
        cs.close()
        db.close()

        if(cc > 0)
        {
            return true
        }

        return false

    }
}