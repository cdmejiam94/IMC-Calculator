package com.preeliminatorylabs.calculadoradeimc.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.calculadoradeimc.R
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData

class AppDataAdapter(val list: List<AppData>, val context: Context) : RecyclerView.Adapter<AppDataAdapter.ViewHolder>() {

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.client_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = list[position].log_id.toString()
        holder.type.text = list[position].type
        holder.name.text = list[position].first_name
        holder.age.text = list[position].age.toString()
        holder.genre.text = list[position].gender.toString()
        holder.height.text = list[position].height.toString()
        holder.weight.text = list[position].weight.toString()
        holder.user.text = list[position].user_name
        holder.password.text = list[position].password
        holder.email.text = list[position].email
        holder.lastName.text = list[position].last_name
        holder.geb.text = list[position].geb.toString()
        holder.id_client.text = list[position].id_client.toString()
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id = itemView.findViewById<TextView>(R.id.blId)
        val type = itemView.findViewById<TextView>(R.id.blType)
        val name = itemView.findViewById<TextView>(R.id.blName)
        val lastName = itemView.findViewById<TextView>(R.id.blLast)
        val age = itemView.findViewById<TextView>(R.id.blAge)
        val genre = itemView.findViewById<TextView>(R.id.blGenre)
        val height = itemView.findViewById<TextView>(R.id.blHeight)
        val weight = itemView.findViewById<TextView>(R.id.blWeight)
        val user = itemView.findViewById<TextView>(R.id.blUser)
        val password = itemView.findViewById<TextView>(R.id.blPassword)
        val email = itemView.findViewById<TextView>(R.id.blEmail)
        val id_client = itemView.findViewById<TextView>(R.id.blIdClient)
        val geb = itemView.findViewById<TextView>(R.id.blGeb)
    }

}