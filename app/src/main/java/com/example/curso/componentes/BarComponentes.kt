package com.example.curso.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TituloBar(nombre: String) {
    Text(text = nombre, fontSize = 25.sp, color = Color.White)

}
