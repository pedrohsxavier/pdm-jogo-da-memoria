package com.example.jogodamemoriatsi

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var gvGame: GridView
    private lateinit var professores: ArrayList<Professor>
    private lateinit var btVoltar: Button
    private lateinit var btRecomecar: Button
    private var first: ImageView? = null
    private var second: ImageView? = null

    private var numberPoints = 0
    private var maxPoints = 8
    private var hit = false

    private var pos = arrayListOf<Int>()
    private var currentPos = -1

    /*private val teachers = intArrayOf(
        R.drawable.alana, R.drawable.alex, R.drawable.candido, R.drawable.crishane,
        R.drawable.damires, R.drawable.denio, R.drawable.edemberg, R.drawable.fausto,
        R.drawable.francisco, R.drawable.fred, R.drawable.giovanni, R.drawable.gustavo,
        R.drawable.heremita, R.drawable.juliana, R.drawable.lafayette, R.drawable.leonidas,
        R.drawable.luiz, R.drawable.nilton, R.drawable.paulo, R.drawable.petronio,
        R.drawable.pryscilla, R.drawable.thiago, R.drawable.valeria, R.drawable.valeria,
        R.drawable.zefilho
    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        professores = intent.getSerializableExtra("PROFESSORES") as ArrayList<Professor>

        mediaPlayer = MediaPlayer.create(this, R.raw.tobu_candyland)
        mediaPlayer?.start()
        mediaPlayer?.isLooping

        val cmTime = findViewById<Chronometer>(R.id.cmTempo)
        cmTime.start()

        gvGame = findViewById(R.id.gvGame)
        val imageAdapter = ImageAdapter(this@GameActivity)
        gvGame.adapter = imageAdapter
        gvGame.setOnItemClickListener(Game())

        var n: Int
        val arrayAux = arrayListOf<Int>()
        while (true) {
            n = Random.nextInt(0, 22) // quantidade de profesores

            if (!arrayAux.contains(n))
                arrayAux.add(n)

            if (arrayAux.size == 8)
                break
        }

        pos.addAll(arrayAux)
        pos.addAll(arrayAux)
        pos = pos.toList().shuffled() as ArrayList<Int>

        this.btVoltar = findViewById(R.id.btVoltar)
        this.btRecomecar = findViewById(R.id.btRecomecar)
        this.btVoltar.setOnClickListener({ opening(it) })
        this.btRecomecar.setOnClickListener( {restartGame(it)} )
    }

    fun opening(view: View) {
        mediaPlayer?.stop()
        finish()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun restartGame(view: View) {
        mediaPlayer?.stop()
        finish()
        var intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    inner class Game : AdapterView.OnItemClickListener {

        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            if (currentPos < 0) {
                if (!hit) {
                    first?.setImageResource(R.drawable.hidden)
                    second?.setImageResource(R.drawable.hidden)
                    hit = false
                }

                currentPos = position
                first = view as ImageView
                view.setImageResource(professores[pos[position]].foto)

            } else {
                if (currentPos == position) {
                    Toast.makeText(this@GameActivity, "Tente novamente!", Toast.LENGTH_SHORT).show()
                } else if (pos[currentPos] != pos[position]) {
                    (view as ImageView).setImageResource(professores[pos[position]].foto)
                    currentPos = -1
                    hit = false
                    second = view
                } else {
                    (view as ImageView).setImageResource(professores[pos[position]].foto)

                    numberPoints++
                    currentPos = -1
                    hit = true
                    second = view
                    first?.setOnClickListener(null)
                    second?.setOnClickListener(null)
                    Toast.makeText(this@GameActivity, "Você acertou!!", Toast.LENGTH_SHORT).show()

                    if (numberPoints == maxPoints) {
                        val intent = Intent()

                        setResult(Activity.RESULT_OK, intent)
                        val response = "Você venceu!"

                        Toast.makeText(this@GameActivity, response, Toast.LENGTH_SHORT).show()
                        mediaPlayer?.stop()
                    }
                }
            }
        }
    }
}
