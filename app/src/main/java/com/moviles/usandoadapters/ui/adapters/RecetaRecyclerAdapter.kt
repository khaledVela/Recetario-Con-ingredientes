package com.moviles.usandoadapters.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.usandoadapters.R
import com.moviles.usandoadapters.ui.models.Receta
import java.util.ArrayList

class RecetaRecyclerAdapter(val data: ArrayList<Receta>, val listener:OnContactClickListener) :
    RecyclerView.Adapter<RecetaRecyclerAdapter.RecetaViewholder>() {
    class RecetaViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lblNombre: TextView
        val ver:Button
        init {
            lblNombre = itemView.findViewById(R.id.nombre)
            ver=itemView.findViewById(R.id.ver)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.receta_item_layout, parent, false)
        return RecetaViewholder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewholder, position: Int) {
        val receta = data[position]
        holder.lblNombre.text=receta.nombres
        holder.ver.setOnClickListener {
            listener.onEditClick(receta)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    interface OnContactClickListener{
        fun onEditClick(receta:Receta)
    }
}