package com.example.jogodamemoriatsi

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class GameActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var gvGame: GridView
    private lateinit var btVoltar: Button
    private lateinit var btRecomecar: Button
    private var first: ImageView? = null
    private var second: ImageView? = null
    private var numberPoints = 0
    private var maxPoints = 8
    private var hit = false


    private val teachers = intArrayOf(
        R.drawable.alana, R.drawable.alex, R.drawable.candido, R.drawable.crishane,
        R.drawable.damires, R.drawable.denio, R.drawable.edemberg, R.drawable.fausto,
        R.drawable.francisco, R.drawable.fred, R.drawable.giovanni, R.drawable.gustavo,
        R.drawable.heremita, R.drawable.juliana, R.drawable.lafayette, R.drawable.leonidas,
        R.drawable.luiz, R.drawable.nilton, R.drawable.paulo, R.drawable.petronio,
        R.drawable.pryscilla, R.drawable.thiago, R.drawable.valeria, R.drawable.valeria,
        R.drawable.zefilho
    )


    private var pos = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7).toList().shuffled()
    private var currentPos = -1
    //private lateinit var playerOnGame: Jogador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        mediaPlayer = MediaPlayer.create(this, R.raw.tobu_candyland)
        mediaPlayer?.start()
        mediaPlayer?.isLooping

        val cmTime = findViewById<Chronometer>(R.id.cmTempo)
        cmTime.start()

        gvGame = findViewById(R.id.gvGame)
        val imageAdapter = ImageAdapter(this@GameActivity)
        gvGame.adapter = imageAdapter
        gvGame.setOnItemClickListener(Game())

        //playerOnGame = intent.getSerializableExtra("Jogador") as Jogador

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
                view.setImageResource(teachers[pos[position]])

            } else {
                if (currentPos == 0) {
                    Toast.makeText(this@GameActivity, "Another try!", Toast.LENGTH_SHORT).show()
                } else if (pos[currentPos] != pos[position]) {
                    (view as ImageView).setImageResource(teachers[pos[position]])
                    currentPos = -1
                    hit = false
                    second = view
                    Toast.makeText(this@GameActivity, "Missed!", Toast.LENGTH_SHORT).show()
                } else {
                    (view as ImageView).setImageResource(teachers[pos[position]])

                    numberPoints++
                    currentPos = -1
                    hit = true
                    second = view
                    first?.setOnClickListener(null)
                    second?.setOnClickListener(null)
                    Toast.makeText(this@GameActivity, "Bull's eye!", Toast.LENGTH_SHORT).show()

                    if (numberPoints == maxPoints) {
                        val intent = Intent()
                        //intent.putExtra("Player", playerOnGame)
                        setResult(Activity.RESULT_OK, intent)
                        val response = "You win!"

                        Toast.makeText(this@GameActivity, response, Toast.LENGTH_SHORT).show()
                        mediaPlayer?.stop()
                        finish()
                    }
                }
            }
        }
    }
}
