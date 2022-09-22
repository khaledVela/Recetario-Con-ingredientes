package com.moviles.usandoadapters.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moviles.usandoadapters.R
import com.moviles.usandoadapters.ui.adapters.IngredientesRecyclerAdapter
import com.moviles.usandoadapters.ui.adapters.verIngredientesRecyclerAdapter
import com.moviles.usandoadapters.ui.models.Ingrediente
import com.moviles.usandoadapters.ui.models.Receta

class VerRecetaActivity : AppCompatActivity() {
    private lateinit var receta:Receta
    private lateinit var adapter: verIngredientesRecyclerAdapter
    private lateinit var lstNames: RecyclerView
    private lateinit var nombre:TextView
    private lateinit var procedim:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_receta)
        lstNames = findViewById(R.id.ingredientelista)
        nombre = findViewById(R.id.nombrereceta)
        procedim = findViewById(R.id.procedimientoreceta)
        receta=intent.getSerializableExtra("receta") as Receta
        setupListview()
    }

    private fun setupListview() {
        nombre.text=receta.nombres
        procedim.text=receta.Procedimiento
        adapter = verIngredientesRecyclerAdapter(receta.Ingrediente)
        lstNames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lstNames.adapter = adapter
    }
}