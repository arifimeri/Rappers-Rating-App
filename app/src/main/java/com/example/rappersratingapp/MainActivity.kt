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

        // Sample rappers data
        rappers.add(Rapper(1, "Eminem", "Mathers", "Eminem","Lose Yourself", 100000))
        rappers.add(Rapper(2, "Jay-Z", "Carter", "Jay-Z", "Empire State of Mind", 80000))
        rappers.add(Rapper(3, "Rigels", "Rajku", "Noizy","Toto", 300000))
        rappers.add(Rapper(4, "Arkimed", "Lushaj", "Stresi", "Loco", 240000))
        rappers.add(Rapper(5, "Melida", "Ademi", "Melinda", "Alkool", 200000))
        rappers.add(Rapper(6, "Doruntina", "Shala", "Tayna", "Edhe Ti", 180000))
        rappers.add(Rapper(7, "Gramoz" ,"Aliu", "Mozzik", "Ti amo", 165000))
        rappers.add(Rapper(8, "Getoar", "Aliu", "Getinjo", "Real", 144000))
        rappers.add(Rapper(9, "Kljedi", "Dogjani", "Finem", "Bling Bling", 130000))
        rappers.add(Rapper(10, "Elvana", "Gjata", "Elvana", "Njesoj", 123000))


        // Add more rappers data here

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
