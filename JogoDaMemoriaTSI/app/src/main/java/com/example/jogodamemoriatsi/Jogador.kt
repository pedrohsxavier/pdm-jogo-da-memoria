package com.example.jogodamemoriatsi

class Jogador {
    var id: Int
    var nome: String
    var pontos: Int

    constructor(id: Int, nome: String, pontos: Int) {
        this.id = id
        this.nome = nome
        this.pontos = 0
    }

    constructor(nome: String, pontos: Int) {
        this.id = -1
        this.nome = nome
        this.pontos = 0
    }

    override fun toString(): String {
        return "${id} - ${nome} - ${pontos}"
    }
}