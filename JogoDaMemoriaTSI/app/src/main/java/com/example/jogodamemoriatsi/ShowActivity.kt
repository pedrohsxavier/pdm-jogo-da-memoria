package com.example.jogodamemoriatsi

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ShowActivity : AppCompatActivity() {
    private lateinit var professores: ArrayList<Professor>
    private lateinit var lvProfessores: ListView
    private lateinit var dao: ProfessorDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        lvProfessores = findViewById(R.id.lvProfessores)
        professores = intent.getSerializableExtra("PROFESSORES") as ArrayList<Professor>

        
        dao = ProfessorDAO(this@ShowActivity)
        inserirProfs()

        lvProfessores.adapter = ListAdapter(this@ShowActivity)

    }

    //Inserindo professores no banco
    private fun inserirProfs() {
        if (dao.get().size <= 0 ) {
            dao.insert(Professor("Alex Sandro da Cunha Rego", "Algoritmo e Prog. Estrut., Banco de Dados II", R.drawable.alex ))
            dao.insert(Professor("Alana Marques de Morais", "BD 2, Análise e Proj. de Sist., Padrões de Projeto de Software",  R.drawable.alana))
            dao.insert(Professor("Candido Jose Ramos do Egypto", "Algoritmo e Prog. Estrut., Banco de Dados I",  R.drawable.candido))
            dao.insert(Professor("Crishane Azevedo Freire", "Algoritmo e Prog. Estrut.",  R.drawable.crishane))
            dao.insert(Professor("Damires Yluska de Souza Fernandes", "Banco de Dados II",  R.drawable.damires))
            dao.insert(Professor("Denio Mariz Timoteo de Sousa", "Segurança de Dados",  R.drawable.denio))
            dao.insert(Professor("Edemberg Rocha da Silva", "Algoritmo e Prog. Estrut.",  R.drawable.edemberg))
            dao.insert(Professor("Fausto Veras Maranhao Ayres", "Prog. Orientada a Objetos, Persistência de Objetos",  R.drawable.fausto))
            dao.insert(Professor("Francisco Petronio Alencar de Medeiros", "Interação Humano-Computador",  R.drawable.petronio))
            dao.insert(Professor("Frederico Costa Guedes Pereira", "Fund. Computação, Programação para Web II", R.drawable.fred))
            dao.insert(Professor("Giovanni Loureiro Franca de Mendonca", "Fund. Computação, ",  R.drawable.giovanni))
            dao.insert(Professor("Heremita Brasileiro Lira", "Comércio Eletrônico, Gerência de Projetos de Software",  R.drawable.heremita))
            dao.insert(Professor("Jose Gomes Quaresma Filho", "Fundamentos de Redes",  R.drawable.zefilho))
            dao.insert(Professor("Pryscilla Marcili Dora", "Fundamentos de Redes",  R.drawable.pryscilla))
            dao.insert(Professor("Francisco Dantas Nobre Neto", "Linguagem de Marcação",  R.drawable.francisco))
            dao.insert(Professor("Thiago Jose Marques Moura", "Linguagem de Marcação, Estrutura de Dados",  R.drawable.thiago))
            dao.insert(Professor("Marcus Vinicius Delgado Varandas", "Legislação Social, Empreendedorismo SI",  R.drawable.varandas))
            dao.insert(Professor("Nilton Freire Santos", "Banco de Dados I",  R.drawable.nilton))
            dao.insert(Professor("Lafayette Batista Melo", "Fund. Metodologia, Métod. e Téc. de Pesquisa",  R.drawable.lafayette))
            dao.insert(Professor("Luiz Carlos Rodrigues Chaves", "Linguagem de Script, Programação para Web I",  R.drawable.luiz))
            dao.insert(Professor("Leonidas Francisco de Lima Junior", "Protoc. de Redes",  R.drawable.leonidas))
            dao.insert(Professor("Gustavo Wagner Diniz Mendes", "Sist. Operacionais",  R.drawable.gustavo))
            dao.insert(Professor("Valeria Maria Bezerra Cavalcanti Maciel", "Padrões de Proj. de Software, Prog. para Disp. Móveis",  R.drawable.valeria))
        }
    }

    inner class ListAdapter(context: Context) : BaseAdapter() {
        private val inflator: LayoutInflater

        init {
            this.inflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return professores.size
        }

        override fun getItem(position: Int): Any {
            return professores[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view = this.inflator.inflate(R.layout.activity_show, parent, false)

            val ivFoto = view.findViewById(R.id.ivImagemProfessores) as ImageView
            val tvNome = view.findViewById(R.id.tvNome) as TextView
            val tvDisciplina = view.findViewById(R.id.tvDisciplina) as TextView

            val professor = professores[position]

            ivFoto.setImageResource(professor.foto)
            tvNome.text = professor.nome
            tvDisciplina.text = professor.disciplina

            ivFoto.setImageResource(professor.foto)

            return view
        }
    }
}
