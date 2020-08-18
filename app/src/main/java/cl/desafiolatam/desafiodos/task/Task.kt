package cl.desafiolatam.desafiodos.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(@ColumnInfo(name = "tarea") var tarea: String) {

    // generar primary key de forma automatica - evita 2 primary key iguales
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}