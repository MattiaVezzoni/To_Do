package com.example.todoappproject

import androidx.room.*

@Dao

interface DAO {
    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query(value = "Delete from to_do")
    suspend fun deleteAll()

    @Query(value = "Select * from to_do")
    suspend fun getTask():List<CardInfo>
}