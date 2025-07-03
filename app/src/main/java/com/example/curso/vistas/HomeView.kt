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
import androidx.navigation.NavController
import com.example.curso.componentes.BotonGenerico
import com.example.curso.componentes.TituloBar
import com.example.curso.componentes.TituloView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun HomeView(navcontroller: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TituloBar(nombre = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )

                )
        }
    ) {
        ContenidoHomeView(navcontroller)
    }
}

@Composable
fun ContenidoHomeView(navcontroller: NavController) {
   Column(
       modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       TituloView(nombre = "Home View")

       BotonGenerico(nombre = "Ir a detalles",
           backColor = Color.White,
           colorText = Color.Red)
       {
           //println("Boton de detalles presionado")
           navcontroller.navigate("detalles")
       }
   }
}