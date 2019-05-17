package com.example.jogodamemoriatsi

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var btJogar: Button
    private lateinit var btRanking: Button
    private lateinit var btProfessores: Button
    private lateinit var btSair: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.disfigure_blank)
        mediaPlayer?.start()
        mediaPlayer?.isLooping

        this.btJogar = findViewById(R.id.btJogar)
        this.btRanking = findViewById(R.id.btRanking)
        this.btProfessores = findViewById(R.id.btProfessores)
        this.btSair = findViewById(R.id.btSair)

        this.btJogar.setOnClickListener( {gameplay(it)} )
        //this.btRanking.setOnClickListener( {rankingAll(it)} )
        //this.btProfessores.setOnClickListener( {professoresIfpb(it)} )
        this.btSair.setOnClickListener( {sair(it)} )
    }

    fun gameplay(view: View) {
        mediaPlayer?.stop()
        var intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    /*fun rankingAll(view: View) {

    }*/

    /*fun professoresIfpb(view: View) {

    }*/

    fun sair(view: View) {
        mediaPlayer?.stop()
        finish()
    }
}
