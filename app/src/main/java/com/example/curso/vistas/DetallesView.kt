package com.example.curso.vistas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.curso.componentes.BotonGenerico
import com.example.curso.componentes.TituloBar
import com.example.curso.componentes.TituloView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetallesView() {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TituloBar(nombre = "Detalles View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        }
    ){ ContenidoDetallesView() }
}

@Composable
fun ContenidoDetallesView() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){        TituloView(nombre = "Detalles View")

        BotonGenerico(nombre = "Ir a home",
            backColor = Color.White,
            colorText = Color.Red)
        {
            println("Regresar a Home")
        } }
}