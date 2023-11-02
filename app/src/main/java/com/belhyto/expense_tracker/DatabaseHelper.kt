package com.belhyto.expense_tracker

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "ExpenseTracker.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE entries(id INTEGER PRIMARY KEY AUTOINCREMENT, description TEXT, amount REAL, type TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS entries")
    }
    fun insertEntry(entry: Entry): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("description", entry.description)
        contentValues.put("amount", entry.amount)
        contentValues.put("type", entry.type)
        return db.insert("entries", null, contentValues) != -1L
    }
}

