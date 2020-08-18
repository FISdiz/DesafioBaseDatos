package cl.desafiolatam.desafiodos.task

import android.content.Context
import android.content.SyncContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskRoomDatabase : RoomDatabase(), TaskDao {

    abstract fun taskDao(): TaskDao

    companion object {
        // singleton --> previene que varias instancias operen en la base de datos al mismo tiempo

        //la base de datos puede ser nula, si no tiene informacion
        @Volatile
        private var INSTANCE: TaskRoomDatabase? = null
        fun getDatabase(context: Context): TaskRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            //si es nula, construye la instancia y la retorna
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDatabase::class.java,
                    "tareas_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}