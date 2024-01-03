package com.example.todobackend.repository

import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.sql.Date

interface TaskRepository : CrudRepository<Task, Long> {
    @Query("select t from Task t " +
            "where (:completion is null or t.completion = :completion) " +
            "and (:priority is null or t.priority = :priority) " +
            "and (:completed is null or t.completed = :completed)")
    fun findAllByParameters(@Param("completion") date: Date?,
                            @Param("priority") priority: Priority?,
                            @Param("completed") completed: Boolean?): List<Task>
}