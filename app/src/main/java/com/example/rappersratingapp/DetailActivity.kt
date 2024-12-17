package com.example.rappersratingapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var detailRank: TextView
    private lateinit var detailName: TextView
    private lateinit var detailFamousSong: TextView
    private lateinit var increaseRankingButton: Button
    private lateinit var rapper: Rapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailRank = findViewById(R.id.detailRank)
        detailName = findViewById(R.id.detailName)
        detailFamousSong = findViewById(R.id.detailFamousSong)
        increaseRankingButton = findViewById(R.id.increaseRankingButton)

        rapper = intent.getSerializableExtra("RAPPER") as Rapper

        detailRank.text = "Rank: ${rapper.rank}"
        detailName.text = "Name: ${rapper.firstName} ${rapper.lastName}"
        detailFamousSong.text = "Famous Song: ${rapper.famousSong}"

        increaseRankingButton.setOnClickListener {
            rapper = rapper.copy(rank = rapper.rank - 1)  // Increase ranking
            detailRank.text = "Rank: ${rapper.rank}"
            Toast.makeText(this, "Ranking increased!", Toast.LENGTH_SHORT).show()
        }
    }
}
