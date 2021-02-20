package com.example.sqlitekotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext

val database_name="MyDatabase"
val table_name="Users"
val col_name="namesurname"
val col_age="age"
val col_idl="id"

class DBHelper (var context: Context):SQLiteOpenHelper(context, database_name,null,1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        var createTable=" CREATE TABLE "+ table_name+"("+
                col_idl+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                col_name+" VARCHAR(256),"+
                col_age+" INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: User){
        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(col_name,user.namesurname)
        cv.put(col_age,user.age)
        var res=db.insert(table_name,null,cv)
        if(res==(-1).toLong()){
            Toast.makeText(context,"Failed!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Successful",Toast.LENGTH_LONG).show()
        }
    }
}