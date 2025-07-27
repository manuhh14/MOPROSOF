package com.example.curso.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.curso.modelos.Alumno

@Dao
interface AlumnoDAO {

    @Query("SELECT * FROM alumnos")
    fun getAll(): List<Alumno>

    @Insert
    fun insertAll(vararg alumno: Alumno)

}