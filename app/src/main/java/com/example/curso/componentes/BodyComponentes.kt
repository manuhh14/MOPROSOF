package com.example.curso.componentes


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TituloView(nombre: String) {
    Text(text = nombre, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

/*Este es un boton generico*/
@Composable
fun BotonGenerico(
    nombre: String,
    backColor: Color,
    colorText: Color, onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = backColor,
            containerColor = colorText
        )
    ) {
        Text(text = nombre)
    }
}