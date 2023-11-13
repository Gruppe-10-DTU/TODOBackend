package com.example.todobackend.repository

import com.example.todobackend.model.Task
import org.springframework.data.repository.CrudRepository
import java.sql.Date

interface TaskRepository : CrudRepository<Task, Long> {

    fun findAllByCompletion(completion: Date): List<Task>

}