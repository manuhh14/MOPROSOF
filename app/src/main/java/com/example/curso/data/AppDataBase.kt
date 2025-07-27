package com.example.curso.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.curso.modelos.Alumno


@Database(entities = [Alumno::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun alumnosDao(): AlumnoDAO


    companion object{
        @Volatile private var INSTANCE: AppDataBase? = null

        fun getInstace(context: Context): AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "alumnos_database"
                ).build()

                INSTANCE = instace
                instace
            }
        }
    }

}