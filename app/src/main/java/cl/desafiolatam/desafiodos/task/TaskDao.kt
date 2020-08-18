package cl.desafiolatam.desafiodos.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE id IN (:taskIds)")
    fun cargaPorIds(taskIds: IntArray): List<Task>

    @Query("SELECT * FROM task WHERE tarea LIKE :tarea LIMIT 1")
    fun findByTask(tarea: String): Task

    @Insert
    fun insert(vararg tarea: Task)

    @Delete
    fun delete(tarea: Task)

}


