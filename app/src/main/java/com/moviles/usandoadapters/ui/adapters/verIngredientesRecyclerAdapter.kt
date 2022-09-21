package com.moviles.usandoadapters.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.usandoadapters.R
import com.moviles.usandoadapters.ui.models.Ingrediente
import java.util.ArrayList

class verIngredientesRecyclerAdapter(
    val data: ArrayList<Ingrediente>,
) :
    RecyclerView.Adapter<verIngredientesRecyclerAdapter.IngredienteViewholder>() {
    class IngredienteViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lblNombre: TextView

        init {
            lblNombre = itemView.findViewById(R.id.ingredientename)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ver_ingrediente, parent, false)
        return verIngredientesRecyclerAdapter.IngredienteViewholder(view)
    }

    override fun onBindViewHolder(holder: IngredienteViewholder, position: Int) {
        val receta = data[position]
        holder.lblNombre.text = receta.nombre
    }

    override fun getItemCount(): Int {
        return data.size
    }
}