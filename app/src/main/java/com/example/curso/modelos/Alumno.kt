package com.example.curso.modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alumnos")
data class Alumno(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    @ColumnInfo val nombre: String,
    @ColumnInfo val edad: Int,
    @ColumnInfo val carrera: String
)
