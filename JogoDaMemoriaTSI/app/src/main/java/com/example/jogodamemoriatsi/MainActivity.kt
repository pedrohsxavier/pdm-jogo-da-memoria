package com.example.jogodamemoriatsi

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_player.*

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    lateinit var professores: ArrayList<Professor>
    private lateinit var btJogar: Button
    //private lateinit var btRanking: Button
    private lateinit var btProfessores: Button
    private lateinit var btSair: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.disfigure_blank)
        mediaPlayer?.start()
        mediaPlayer?.isLooping

        this.btJogar = findViewById(R.id.btJogar)
        //this.btRanking = findViewById(R.id.btRanking)
        this.btProfessores = findViewById(R.id.btProfessores)
        this.btSair = findViewById(R.id.btSair)

        this.btJogar.setOnClickListener( {gameplay(it)} )
        //this.btRanking.setOnClickListener( {rankingAll(it)} )
        this.btProfessores.setOnClickListener( {professoresIfpb(it)} )
        this.btSair.setOnClickListener( {sair(it)} )

        professores = arrayListOf(
            Professor(
                "Alana Marques de Morais",
                "Padrões de Projeto de Software",
                R.drawable.alana
            ),
            Professor(
                "Alex Sandro da Cunha Rego",
                "Algoritmo e Programação Estruturada",
                R.drawable.alex
            ),
            Professor(
                "Candido José Ramos do Egypto",
                "Algoritmo e Programação Estruturada",
                R.drawable.candido
            ),
            Professor(
                "Crishane Azevedo Freire",
                "Algoritmo e Programação Estruturada",
                R.drawable.crishane
            ),
            Professor(
                "Damires Yluska de Souza Fernandes",
                "Banco de Dados II",
                R.drawable.damires
            ),
            Professor(
                "Denio Mariz Timoteo de Sousa",
                "Segurança de Dados",
                R.drawable.denio
            ),
            Professor(
                "Edemberg Rocha da Silva",
                "Algoritmo e Programação Estruturada",
                R.drawable.edemberg
            ),
            Professor(
                "Fausto Veras Maranhão Ayres",
                "Programação Orientada a Objetos",
                R.drawable.fausto
            ),
            Professor(
                "Francisco Dantas Nobre Neto",
                "Linguagens de Marcação",
                R.drawable.francisco
            ),
            Professor(
                "Francisco Petrônio Alencar de Medeiros",
                "Interação Humano-Computador",
                R.drawable.petronio
            ),
            Professor(
                "Frederico Costa Guedes Pereira",
                "Programação Para Web II",
                R.drawable.fred
            ),
            Professor(
                "Giovanni Loureiro Franca de Mendonca",
                "Fundamentos da Computação",
                R.drawable.giovanni
            ),
            Professor(
                "Gustavo Wagner Diniz Mendes",
                "Sistemas Operacionais",
                R.drawable.gustavo
            ),
            Professor(
                "Heremita Brasileiro Lira",
                "Gerência de Projetos de Software",
                R.drawable.heremita
            ),
            Professor(
                "Juliana Dantas Ribeiro Viana de Medeiros",
                "Desenvolvimento e Execução de Projetos de Software",
                R.drawable.juliana
            ),
            Professor(
                "Lafayette Batista Melo",
                "Fundamentos da Metodologia Científica",
                R.drawable.lafayette
            ),
            Professor(
                "Leonidas Francisco de Lima Junior",
                "Protocolos e Interconexão de Redes de Computadores",
                R.drawable.leonidas
            ),
            Professor(
                "Luiz Carlos Rodrigues Chaves",
                "Linguagens de Script",
                R.drawable.luiz
            ),
            Professor(
                "Marcus Vinicius Delgado Varandas",
                "Empreendedorismo",
                R.drawable.varandas
            ),
            Professor(
                "Nilton Freire Santos",
                "Banco de Dados I",
                R.drawable.nilton
            ),
            Professor(
                "Pryscilla Marcili Dora",
                "Fundamentos de Redes de Computadores",
                R.drawable.pryscilla
            ),
            Professor(
                "Thiago Jose Marques Moura",
                "Linguagens de Marcação",
                R.drawable.thiago
            ),
            Professor(
                "Valeria Maria Bezerra Cavalcanti Maciel",
                "Programação Para Dispositivos Móveis",
                R.drawable.valeria
            )
        )
    }

    fun gameplay(view: View) {

//        val box = AlertDialog.Builder(this)
//        val view = layoutInflater.inflate(R.layout.activity_player, null)
//        val nomePlayer =  view.findViewById(R.id.etNomeJogador) as EditText
//        val cadastro = view.findViewById(R.id.btCadastrar) as Button
//        box.setView(view)
//        cadastro.setOnClickListener({Toast.makeText(this, "Cadastrado concluído!", Toast.LENGTH_LONG).show()})

//      cadastro.setOnClickListener(View.OnClickListener { fun onClick(view: View) {
//          if (!nomePlayer.toString().isEmpty()) {
//              Toast.makeText(this, "Jogador cadastrado", Toast.LENGTH_LONG).show()
//          }
//      } })

//        val box1 = AlertDialog.Builder(this)
//        box.setTitle("Digite o seu nome: ")
//        val inflater = layoutInflater
//        val dialogLayout = inflater.inflate(R.layout.abc_alert_dialog_button_bar_material, null)
//        val editText = dialogLayout.findViewById<EditText>(R.id.etNomeJogador)
//        box1.setView(dialogLayout)
//        box1.setPositiveButton("OK") {dialogInterface, i -> Toast.makeText(this, "Novo jogador cadastrado!", Toast.LENGTH_LONG).show()}
//        box1.show()

        mediaPlayer?.stop()

        var intent = Intent(this, GameActivity::class.java)
        startActivityForResult(intent, 1)
    }

    /*fun rankingAll(view: View) {


    }*/

    fun professoresIfpb(view: View) {
        val intent = Intent(this, ShowActivity::class.java)
        intent.putExtra("PROFESSORES", this.professores)
        startActivity(intent)
    }

    fun sair(view: View) {
        mediaPlayer?.stop()
        finish()
    }
}
