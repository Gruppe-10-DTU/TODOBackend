package com.example.todobackend.repository

import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.sql.Date

interface TaskRepository : CrudRepository<Task, Long> {
    @Query("select t from Task t " +
            "where (t.completion is null or t.completion = #{date}) " +
            "and (t.priority is null or t.priority = #{priority}) " +
            "and (t.completed is null or t.completed = #{completed})", nativeQuery = true)
    fun findAllByParameters(date: Date?, priority: Priority?, completed: Boolean?): List<Task>
}