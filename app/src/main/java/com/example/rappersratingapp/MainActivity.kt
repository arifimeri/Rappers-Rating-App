package com.example.rappersratingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rappersratingapp.DetailActivity
import com.example.rappersratingapp.R
import com.example.rappersratingapp.Rapper
import com.example.rappersratingapp.RapperAdapter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var rappersListView: ListView
    private lateinit var topButton: Button
    private lateinit var bottomButton: Button

    private val rappers = ArrayList<Rapper>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rappersListView = findViewById(R.id.rappersListView)
        topButton = findViewById(R.id.topButton)
        bottomButton = findViewById(R.id.bottomButton)


        rappers.add(Rapper(1, "Eminem", "Mathers", "Eminem","Lose Yourself", 100000, imageUrl = R.drawable.eminem))
        rappers.add(Rapper(2, "Jay-Z", "Carter", "Jay-Z", "Empire State of Mind", 80000, imageUrl = R.drawable.jayz))
        rappers.add(Rapper(3, "Rigels", "Rajku", "Noizy","Toto", 300000, imageUrl = R.drawable.rigels))
        rappers.add(Rapper(4, "Arkimed", "Lushaj", "Stresi", "Loco", 240000, R.drawable.rigels))
        rappers.add(Rapper(5, "Melida", "Ademi", "Melinda", "Alkool", 200000, R.drawable.melinda))
        rappers.add(Rapper(6, "Doruntina", "Shala", "Tayna", "Edhe Ti", 180000, R.drawable.tayna))
        rappers.add(Rapper(7, "Gramoz" ,"Aliu", "Mozzik", "Ti amo", 165000, imageUrl = R.drawable.mozzik))
        rappers.add(Rapper(8, "Getoar", "Aliu", "Getinjo", "Real", 144000, imageUrl = R.drawable.getinjo))
        rappers.add(Rapper(9, "Kljedi", "Dogjani", "Finem", "Bling Bling", 130000, imageUrl = R.drawable.finem))
        rappers.add(Rapper(10, "Elvana", "Gjata", "Elvana", "Njesoj", 123000, imageUrl = R.drawable.elvana))
        rappers.add(Rapper(11, "Dafina", "Zeqiri", "Dafina", "Dafine Moj", 100000, imageUrl = R.drawable.dafina))
        rappers.add(Rapper(12, "Drake", "Graham", "Drake", "God's Plan", 900000, imageUrl = R.drawable.drake))
        rappers.add(Rapper(13, "Kanye", "West", "Kanye West", "Stronger", 950000, imageUrl = R.drawable.kanye))
        rappers.add(Rapper(14, "Travis", "Scott", "Travis Scott", "SICKO MODE", 850000, imageUrl = R.drawable.travis))
        rappers.add(Rapper(15, "Nicki", "Minaj", "Nicki Minaj", "Anaconda", 1200000, imageUrl = R.drawable.nicki))
        rappers.add(Rapper(16, "Lil", "Wayne", "Lil Wayne", "Lollipop", 1000000, imageUrl = R.drawable.lilwayne))
        rappers.add(Rapper(17, "Cardi", "B", "Cardi B", "I Like It", 950000, imageUrl = R.drawable.cardi))
        rappers.add(Rapper(18, "Post", "Malone", "Post Malone", "Rockstar", 950000, imageUrl = R.drawable.postmalone))
        rappers.add(Rapper(19, "J Cole", "Cole", "J Cole", "Middle Child", 800000, imageUrl = R.drawable.jcole))
        rappers.add(Rapper(20, "Lil", "Uzi Vert", "Lil Uzi Vert", "XO Tour Llif3", 880000, imageUrl = R.drawable.liluzi))
        rappers.add(Rapper(21, "Snoop", "Dogg", "Snoop Dogg", "Drop It Like It's Hot", 1100000, imageUrl = R.drawable.snoop))




        val adapter = RapperAdapter(this, rappers)
        rappersListView.adapter = adapter

        rappersListView.setOnItemClickListener { _, _, position, _ ->
            val selectedRapper = rappers[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("RAPPER", selectedRapper)
            }
            startActivity(intent)
        }

        topButton.setOnClickListener {
            val top3 = rappers.sortedBy { it.rank }.take(3)
            val adapter = RapperAdapter(this, ArrayList(top3))
            rappersListView.adapter = adapter
        }

        bottomButton.setOnClickListener {
            val bottom3 = rappers.sortedByDescending { it.salary }.take(3)
            val adapter = RapperAdapter(this, ArrayList(bottom3))
            rappersListView.adapter = adapter
        }
    }

}
