package com.moviles.usandoadapters.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moviles.usandoadapters.R
import com.moviles.usandoadapters.ui.adapters.IngredientesRecyclerAdapter
import com.moviles.usandoadapters.ui.adapters.RecetaRecyclerAdapter
import com.moviles.usandoadapters.ui.models.Ingrediente
import com.moviles.usandoadapters.ui.models.Receta

class MainActivity : AppCompatActivity(),IngredientesRecyclerAdapter.OnIngredClickListener {
    private lateinit var enviar: Button
    private lateinit var adapter: IngredientesRecyclerAdapter
    private lateinit var lstNames: RecyclerView
    var lista= arrayListOf<Ingrediente>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enviar = findViewById(R.id.button)
        lstNames=findViewById(R.id.ingredientes)
        setupListview()
    }

    private fun setupListview() {
        val contactos = arrayListOf(
            Ingrediente(1,"Cebolla",R.drawable.cebolla),
            Ingrediente(2,"Pollo",R.drawable.pollo),
            Ingrediente(3,"Carne",R.drawable.carne),
            Ingrediente(4,"Naranja",R.drawable.naranja),
            Ingrediente(5,"Mantequilla",R.drawable.mantequilla),
            Ingrediente(6,"Ajo",R.drawable.ajo)
        )
        adapter = IngredientesRecyclerAdapter(contactos,this)
        lstNames.layoutManager = GridLayoutManager(this, 2)
        lstNames.adapter = adapter
        enviar.setOnClickListener {
            val intent = Intent(this, ListaRecetaActivity::class.java)
            intent.putExtra("array", lista)
            startActivity(intent)
        }
    }

    override fun onEditClick(receta: Ingrediente) {
        lista.add(receta)
    }
}