package com.example.rappersratingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class RapperAdapter(context: Context, private val rappers: ArrayList<Rapper>) :
    ArrayAdapter<Rapper>(context, 0, rappers) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rapper = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_rapper, parent, false)

        val rankText = view.findViewById<TextView>(R.id.rankText)
        val nameText = view.findViewById<TextView>(R.id.nameText)
        val famousSongText = view.findViewById<TextView>(R.id.famousSongText)
        val rapperImage = view.findViewById<ImageView>(R.id.rapperImage)


        rankText.text = rapper?.rank.toString()
        nameText.text = "${rapper?.firstName} ${rapper?.lastName}"
        famousSongText.text = rapper?.famousSong
        if (rapper != null) {
            if (rapper.imageUrl > 0){
                rapperImage.setImageResource(rapper.imageUrl)
            }
            else{
                rapperImage.setImageResource(R.drawable.default_rapper)
            }
        }
        return view
    }
}
