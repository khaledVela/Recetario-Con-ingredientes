package com.moviles.usandoadapters.ui.models

import java.io.Serializable

class Receta(
    var id: Int,
    var nombres: String,
    var Procedimiento: String,
    var Ingrediente: ArrayList<Ingrediente>
):Serializable