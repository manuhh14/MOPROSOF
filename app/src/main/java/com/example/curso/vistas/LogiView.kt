package com.example.curso.vistas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.curso.componentes.BotonGenerico
import com.example.curso.componentes.Espacio
import com.example.curso.componentes.TituloBar
import com.example.curso.componentes.TituloView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TituloBar(nombre = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )

            )
        }
    ) { }
}

@Composable
fun ContenidoLoginView(onLoginsuccess: () -> Unit) {

    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TituloView("Iniciar Sesión")

        Espacio()
        OutlinedTextField(
            value = usuario,
            onValueChange = {usuario = it},
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Espacio()

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Espacio()

        BotonGenerico(
            nombre = "Iniciar sesion",
            backColor = Color.Blue,
            colorText = Color.White
        ) {
            /*evento*/
            onLoginsuccess()
        }

    }
}