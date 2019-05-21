package com.example.jogodamemoriatsi

import java.io.Serializable

class Professor: Serializable {
    var id: Int = 0
    var nome: String
    var disciplina: String
    var foto: Int

    constructor(id: Int, nome: String, disciplina: String, foto: Int) {

        this.id = id
        this.nome = nome
        this.disciplina = disciplina
        this.foto = foto
    }

    constructor(nome: String, disciplina: String, foto: Int) {

        this.nome = nome
        this.disciplina = disciplina
        this.foto = foto
    }

    override fun toString(): String {
        return "${nome} - ${disciplina} - ${foto}"
    }
}