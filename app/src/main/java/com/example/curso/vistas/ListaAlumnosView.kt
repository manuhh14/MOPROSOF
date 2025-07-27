package com.example.curso.vistas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.curso.componentes.BotonGenerico
import com.example.curso.componentes.BotonIcono
import com.example.curso.componentes.Espacio
import com.example.curso.componentes.TituloBar
import com.example.curso.componentes.TituloView
import com.example.curso.data.AlumnoViewModel
import com.example.curso.modelos.Alumno


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaAlumnosView(
    navController: NavController,
    viewmodel: AlumnoViewModel
) {

    /** evento de navegacion **/
    Scaffold(
        topBar = {
            /** evento de navegacion **/
            CenterAlignedTopAppBar(
                title = { TituloBar(nombre = "Lista Alumnos") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    /** evento de navegacion **/
                    BotonIcono(icon = Icons.Default.ArrowBack)
                    {
                        /** evento de navegacion **/
                        navController.popBackStack()
                    }
                }
            )
        },
        bottomBar = {
            Box (modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
                contentAlignment = Alignment.Center)
            {

                BotonGenerico(
                    nombre = "Registrar Alumno",
                    backColor = Color.Red,
                    colorText = Color.White
                )
                {
                    navController.navigate("Registro")
                }
            }
        }
    ) { paddingValues ->
            ContenidoListaAlumnos(paddingValues, viewmodel)
    }
}

@Composable
fun ContenidoListaAlumnos(
    paddingValues: PaddingValues,
    viewmodel: AlumnoViewModel
) {

    val alumnos = viewmodel.listaAlumnos

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ){
        TituloView("Lista de Alumnos")
        Espacio()

        alumnos.forEach { alumno ->

           AlumnoCar(alumno= alumno)
        }
    }
}



@Composable
fun AlumnoCar(alumno: Alumno){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color(0xffe3e5ee))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "perfil",
                tint = Color.Blue,
                modifier = Modifier
                    .size(56.dp)
                    .padding(end = 16.dp)
            )

            Column {
                Text(text = alumno.nombre,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black)

                Text(text = "edad: ${alumno.edad}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black)

                Text(text = alumno.carrera,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black)
            }
        }
    }
}