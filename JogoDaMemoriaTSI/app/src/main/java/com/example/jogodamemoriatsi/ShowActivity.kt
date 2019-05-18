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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        lvProfessores = findViewById(R.id.lvProfessores)
        professores = intent.getSerializableExtra("PROFESSORES") as ArrayList<Professor>
        lvProfessores.adapter = ListAdapter(this@ShowActivity)
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
