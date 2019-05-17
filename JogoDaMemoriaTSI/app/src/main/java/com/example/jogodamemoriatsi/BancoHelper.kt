package com.example.jogodamemoriatsi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context): SQLiteOpenHelper(context, "banco", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table teacher (" +
                "id integer primary key autoincrement, " +
                "nome text, " +
                "pontos integer" +
                ")"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}