package com.example.curso.data

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.curso.modelos.Alumno
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlumnoViewModel(application: Application) : AndroidViewModel(application){

    private val alumnoDAO= AppDataBase.getInstace(application).alumnosDao()
    val listaAlumnos = mutableStateListOf<Alumno>()

    init {
        cargarAlumnos()
    }

    fun cargarAlumnos(){
        viewModelScope.launch(Dispatchers.IO){
            val alumnos = alumnoDAO.getAll()
            listaAlumnos.clear()
            listaAlumnos.addAll(alumnos)
        }
    }

    fun insertarAlumno(alumno: Alumno, onSuccess: ()-> Unit){
        viewModelScope.launch(Dispatchers.IO){
            alumnoDAO.insertAll(alumno)
            cargarAlumnos()

            launch(Dispatchers.Main){
                onSuccess()
            }
        }
    }
}

class AlumnoViewModelFactory(private val applcation: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlumnoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return AlumnoViewModel(applcation) as T
        } else {
            throw IllegalArgumentException("ViewModel no soportado")
        }
    }
}


