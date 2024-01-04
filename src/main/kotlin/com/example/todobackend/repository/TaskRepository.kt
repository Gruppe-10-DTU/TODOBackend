package com.example.todobackend.repository

import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.sql.Timestamp

interface TaskRepository : CrudRepository<Task, Long> {
    @Query("select t from Task t " +
            "where (:deadline is null or t.deadline = :deadline) " +
            "and (:priority is null or t.priority = :priority) " +
            "and (:completed is null or t.completed = :completed)")
    fun findAllByParameters(@Param("deadline") date: Timestamp?,
                            @Param("priority") priority: Priority?,
                            @Param("completed") completed: Boolean?): List<Task>
}