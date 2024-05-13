package com.example.testa

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val dataList: List<CustomModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.textViewName.text = currentItem.name
        holder.textViewDescription.text = currentItem.date.toString()
        holder.c2.setOnClickListener {
            val intent = Intent(context, read::class.java)
            intent.putExtra("id", currentItem.id)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewDescription: TextView = itemView.findViewById(R.id.desk)
        val c2:ConstraintLayout = itemView.findViewById(R.id.c2)
    }
}
