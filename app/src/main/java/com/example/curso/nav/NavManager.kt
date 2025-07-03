package com.example.curso.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.curso.vistas.DetallesView
import com.example.curso.vistas.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeView(navController)
        }
        composable("detalles"){
            DetallesView(navController)
        }
    }
}