package com.example.curso.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.curso.modelos.Alumno
import com.example.curso.vistas.DetallesView
import com.example.curso.vistas.HomeView
import com.example.curso.vistas.ListaAlumnosView
import com.example.curso.vistas.LoginView
import com.example.curso.vistas.RegistroView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    val alumno = remember { mutableStateOf(mutableListOf<Alumno>()) }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginView(navController){
                navController.navigate("ListaAlumnos")
            }
        }

        composable("Registro") {
            RegistroView(navController, alumno.value)

        }

        composable("ListaAlumnos") {
            ListaAlumnosView(navController, alumno.value)
        }

        composable("home") {
            HomeView(navController)
        }
        composable("detalles"){
            DetallesView(navController)
        }
    }
}