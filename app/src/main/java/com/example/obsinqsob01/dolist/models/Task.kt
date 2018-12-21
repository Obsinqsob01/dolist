package com.example.obsinqsob01.dolist.models

import java.io.Serializable
import java.util.*
import androidx.*

@Entity
data class Task(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "hour") var hour: Date?
) : Serializable

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task>

    @Query("SELECT * FROM tasks WHERE uid = :uid")
    fun findByUID(uid: Int): Task

    @Insert
    fun insertAll(vararg tasks: Task)

    @Delete
    fun delete(tasks: Task)

}

@Database(entities = arrayOf(Task::class), version = 1)
abstract class TaskDatabase() : RoomDatabase() {
    abstract fun TaskDao() : TaskDao
}

