package com.example.curso.vistas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.curso.componentes.BotonGenerico
import com.example.curso.componentes.BotonIcono
import com.example.curso.componentes.Espacio
import com.example.curso.componentes.TituloBar
import com.example.curso.componentes.TituloView
import com.example.curso.modelos.Alumno

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegistroView(navController: NavController,alumnos: MutableList<Alumno>){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TituloBar(nombre = "Registro") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    BotonIcono(icon = Icons.Default.ArrowBack)
                    {
                        /** evento de navegacion **/
                    }
                }

            )
        }
    ) { paddingValues ->
        ContenidoRegistroView(paddingValues,navController,alumnos)
    }
}


@Composable
fun ContenidoRegistroView(
    paddingValues: PaddingValues,
    navController: NavController,
    alumnos: MutableList<Alumno>
) {

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var carrera by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        TituloView("Registro de Alumnos")
        Espacio()

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Espacio()
        OutlinedTextField(
            value = edad,
            onValueChange = {edad = it},
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Espacio()
        OutlinedTextField(
            value = carrera,
            onValueChange = {carrera = it},
            label = { Text("Carrera") },
            modifier = Modifier.fillMaxWidth()
        )
        Espacio()
        BotonGenerico(
            nombre= "Registrar",
            backColor = Color.White,
            colorText = Color.Red
        ) {
            val edadInt = edad.toIntOrNull() ?: 0
            val alumno = Alumno(nombre.trim(), edadInt, carrera.trim())
            alumnos.add(alumno)

            nombre = ""
            edad= ""
            carrera = ""

            navController.popBackStack()
        }
    }
}