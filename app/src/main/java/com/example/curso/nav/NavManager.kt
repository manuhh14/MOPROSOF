package com.example.curso.nav

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.curso.data.AlumnoViewModel
import com.example.curso.data.AlumnoViewModelFactory
import com.example.curso.modelos.Alumno
import com.example.curso.vistas.DetallesView
import com.example.curso.vistas.HomeView
import com.example.curso.vistas.ListaAlumnosView
import com.example.curso.vistas.LoginView
import com.example.curso.vistas.RegistroView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    ///val alumno = remember { mutableStateOf(mutableListOf<Alumno>()) }
    val context = LocalContext.current.applicationContext as Application

    val alumnoViewModel: AlumnoViewModel= viewModel(
        factory = AlumnoViewModelFactory(context)
    )

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginView(navController){
                navController.navigate("ListaAlumnos")
            }
        }

        composable("Registro") {
            RegistroView(navController, alumnoViewModel)

        }

        composable("ListaAlumnos") {
            ListaAlumnosView(navController, alumnoViewModel)
        }

        composable("home") {
            HomeView(navController)
        }
        composable("detalles"){
            DetallesView(navController)
        }
    }
}