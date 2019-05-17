package com.example.jogodamemoriatsi

class Professor {
    var id: Int
    var nome: String
    var disciplina: String

    constructor(id: Int, nome: String, disciplina: String) {
        this.id = id
        this.nome = nome
        this.disciplina = disciplina
    }

    constructor(nome: String, disciplina: String) {
        this.id = -1
        this.nome = nome
        this.disciplina = disciplina
    }

    override fun toString(): String {
        return "${id} - ${nome} - ${disciplina}"
    }
}