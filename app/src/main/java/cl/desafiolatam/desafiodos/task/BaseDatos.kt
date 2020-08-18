package cl.desafiolatam.desafiodos.task

import android.content.Context
import android.content.SyncContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskRoomDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        // singleton


        @Volatile
        private var INSTANCE: TaskRoomDatabase? = null

        fun getDatabase(context: Context): TaskRoomDatabase? {
            if (INSTANCE != null) {
                return INSTANCE
            }

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