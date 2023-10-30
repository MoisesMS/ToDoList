package com.rusker.practicarecyclerview

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val todoList : MutableList<Notas>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val text : TextView
		val boton : Button

		init {
			text = view.findViewById(R.id.titulo)
			boton = view.findViewById(R.id.marcar)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.todo_list, parent, false)

		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
		holder.text.text = todoList[position].nota

		holder.boton.setOnClickListener {
			if(!todoList[position].completo) {
				holder.text.setTextColor(Color.parseColor("#00FF00"))
				holder.boton.text = "Marcar como no completado"
				todoList[position].completo = true
			} else {
				holder.text.setTextColor(Color.parseColor("#FF0000"))
				holder.boton.text = "Marcar como completado"
				todoList[position].completo = false
			}
			Log.d(holder.text.text as String, "Completado")

		}
	}

	override fun getItemCount() = todoList.size
}