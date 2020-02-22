package com.preeliminatorylabs.calculadoradeimc.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.calculadoradeimc.R
import com.preeliminatorylabs.calculadoradeimc.model.Client

class ClientDataAdapter (val list: List<Client>, val context: Context) : RecyclerView.Adapter<ClientDataAdapter.ViewHolder>() {

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
        holder.idClient.text = list[position].client_id.toString()
        holder.userName.text = list[position].user_name
        holder.password.text = list[position].password
        holder.email.text = list[position].email
        holder.name.text = list[position].name
        holder.lastName.text = list[position].last_name
        holder.age.text = list[position].age.toString()
        holder.height.text = list[position].height.toString()
        holder.weight.text = list[position].weight.toString()
        holder.genre.text = list[position].gender.toString()
        holder.imc.text = list[position].imc.toString()
        holder.geb.text = list[position].geb.toString()
        holder.created_at.text = list[position].created_at
        holder.updated_at.text = list[position].updated_at
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val idClient = itemView.findViewById<TextView>(R.id.txtClientId)
        val userName = itemView.findViewById<TextView>(R.id.txtUserName)
        val password = itemView.findViewById<TextView>(R.id.txtPassword)
        val email = itemView.findViewById<TextView>(R.id.txtEmail)
        val name = itemView.findViewById<TextView>(R.id.txtName)
        val lastName = itemView.findViewById<TextView>(R.id.txtLastName)
        val age = itemView.findViewById<TextView>(R.id.txtAge)
        val height = itemView.findViewById<TextView>(R.id.txtHeight)
        val weight = itemView.findViewById<TextView>(R.id.txtWeight)
        val genre = itemView.findViewById<TextView>(R.id.txtGenre)
        val imc = itemView.findViewById<TextView>(R.id.txtIMC)
        val geb = itemView.findViewById<TextView>(R.id.txtGEB)
        val created_at = itemView.findViewById<TextView>(R.id.txtCreationDate)
        val updated_at = itemView.findViewById<TextView>(R.id.txtUpdateDate)
    }

}