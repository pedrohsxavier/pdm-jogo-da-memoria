package com.example.jogodamemoriatsi

import android.content.ContentValues
import android.content.Context

class ProfessorDAO {

    private var banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    //Create
    fun insert(p: Professor) {
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("foto", p.foto)
        this.banco.writableDatabase.insert("teacher", null, cv)
    }

    //All
    fun get(): ArrayList<Professor> {
        val colunas = arrayOf("id", "nome", "disciplina", "foto")
        val lista = ArrayList<Professor>()

        val c = this.banco.readableDatabase.query("table", colunas, null, null, null, null, "nome")
        c.moveToFirst()

        if (c.count > 0) {
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val disciplina = c.getString(c.getColumnIndex("disciplina"))
                val foto = c.getInt(c.getColumnIndex("foto"))
                lista.add(Professor(id, nome, disciplina, foto))
            }while (c.moveToNext())
        }

        return lista
    }

    //Find
    fun get(index: Int): Professor? {
        val colunas = arrayOf("id", "nome", "disciplina", "foto")
        val where = "id = ?"
        val pwhere = arrayOf(index.toString())

        val c = this.banco.readableDatabase.query("teacher", colunas, where, pwhere, null, null, null)
        c.moveToFirst()

        if (c.count > 0) {
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val disciplina = c.getString(c.getColumnIndex("disciplina"))
            val foto = c.getInt(c.getColumnIndex("foto"))
            return Professor(id, nome, disciplina, foto)
        }

        return null
    }

    //Update
    fun update(p: Professor) {
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())
        val cv = ContentValues()
        cv.put("id", p.id)
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("foto", p.foto)

        this.banco.writableDatabase.update("teacher", cv, where, pwhere)
    }

    //Delete
    fun delete(id: Int) {
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())

        this.banco.writableDatabase.delete("teacher", where, pwhere)
    }
}