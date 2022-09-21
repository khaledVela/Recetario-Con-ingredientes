package com.moviles.usandoadapters.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.usandoadapters.R
import com.moviles.usandoadapters.ui.models.Ingrediente
import com.moviles.usandoadapters.ui.models.Receta
import java.util.ArrayList

class IngredientesRecyclerAdapter(val data: ArrayList<Ingrediente>, val listener: OnIngredClickListener) :
    RecyclerView.Adapter<IngredientesRecyclerAdapter.IngredienteViewholder>() {
    class IngredienteViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lblNombre: TextView
        val imagen: ImageView
        val anadir:Button
        init {
            lblNombre = itemView.findViewById(R.id.name)
            imagen=itemView.findViewById(R.id.foto)
            anadir=itemView.findViewById(R.id.anadir)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ingrediente_item, parent, false)
        return IngredientesRecyclerAdapter.IngredienteViewholder(view)
    }

    override fun onBindViewHolder(holder: IngredienteViewholder, position: Int) {
        val receta = data[position]
        holder.lblNombre.text=receta.nombre
        holder.imagen.setImageResource(receta.image)
        holder.anadir.setOnClickListener {
            listener.onEditClick(receta)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    interface OnIngredClickListener{
        fun onEditClick(receta:Ingrediente)
    }
}