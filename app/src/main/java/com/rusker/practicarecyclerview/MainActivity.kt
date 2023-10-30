package com.rusker.practicarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO AÑADIR PERSISTENCIA DE DATOS CON FIREBASE O CON SQLITE

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val todoList = mutableListOf<Notas>()
		val agregarTarea: FloatingActionButton = findViewById(R.id.agregarTarea)

		val adapter = CustomAdapter(todoList)

		val recyclerView: RecyclerView = findViewById(R.id.todo)
		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.adapter = adapter

		agregarTarea.setOnClickListener {
			val builder = AlertDialog.Builder(this)
			val input = EditText(this)
			builder.setView(input)
			builder.setTitle("Agregar nueva tarea")

			builder.setPositiveButton(android.R.string.yes) { _, _ ->
				if (input.text.toString() == "") {
					val toast = Toast.makeText(this, "El texto no puede estar vacío", Toast.LENGTH_SHORT)
					toast.show()
				} else {
					todoList.add(Notas(input.text.toString(), false))
					adapter.notifyItemChanged(todoList.size - 1)
				}
			}

			builder.show()
		}
	}
}
