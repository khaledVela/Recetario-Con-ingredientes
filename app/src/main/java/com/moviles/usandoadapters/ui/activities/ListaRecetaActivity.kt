package com.moviles.usandoadapters.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moviles.usandoadapters.R
import com.moviles.usandoadapters.ui.adapters.RecetaRecyclerAdapter
import com.moviles.usandoadapters.ui.models.Ingrediente
import com.moviles.usandoadapters.ui.models.Receta

class ListaRecetaActivity : AppCompatActivity(), RecetaRecyclerAdapter.OnContactClickListener {
    private lateinit var adapter: RecetaRecyclerAdapter
    private lateinit var lstNames: RecyclerView
    private lateinit var ingrediente: ArrayList<Ingrediente>
    private var lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet, massa nec venenatis gravida, ante elit pellentesque orci, id commodo mi felis ut erat. Suspendisse malesuada bibendum urna a luctus. Donec sit amet scelerisque ipsum, ac efficitur nisi. Praesent et vehicula diam, eu laoreet velit. Maecenas at pharetra sem, laoreet scelerisque ex. Pellentesque dictum finibus risus. Curabitur interdum felis vitae elit sodales, condimentum scelerisque nibh eleifend. Etiam non ultricies felis. Sed in lorem nec lectus maximus iaculis. Mauris sed turpis non nisl aliquam dapibus ut nec enim. Phasellus quis venenatis augue. Fusce vitae luctus nulla, ut semper mauris. Suspendisse eget mi id nulla egestas ultricies sed in urna."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_receta)
        lstNames = findViewById(R.id.lstname)
        setupListview()
    }

    private fun setupListview() {
        val recetaparaing = arrayListOf<Receta>()
        val receta = arrayListOf(
            Receta(
                1, "Pollo a la naranja", lorem, arrayListOf(
                    Ingrediente(1, "Cebolla", R.drawable.pollo),
                    Ingrediente(2, "Pollo", R.drawable.pollo),
                    Ingrediente(4, "Naranja", R.drawable.pollo),
                    Ingrediente(5, "Mantequilla", R.drawable.pollo),
                )
            ),
            Receta(
                1, "Carne asada", lorem, arrayListOf(
                    Ingrediente(1, "Cebolla", R.drawable.pollo),
                    Ingrediente(3, "Carne", R.drawable.pollo),
                    Ingrediente(6, "Ajo", R.drawable.pollo)
                )
            )
        )
        val ingrediente = intent.getSerializableExtra("array") as ArrayList<Ingrediente>
        for (r in receta) {
            for (ri in r.Ingrediente){
                for (j in ingrediente) {
                    if(ri.id==j.id && !recetaparaing.contains(r)){
                        recetaparaing.add(r)
                    }
                }
            }
        }
        adapter = RecetaRecyclerAdapter(recetaparaing, this)
        lstNames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lstNames.adapter = adapter
    }

    override fun onEditClick(contacto: Receta) {
        val intent = Intent(this, VerRecetaActivity::class.java)
        intent.putExtra("receta", contacto)
        startActivity(intent)
    }
}