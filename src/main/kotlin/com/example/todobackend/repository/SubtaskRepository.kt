package com.example.todobackend.repository

import com.example.todobackend.model.Subtask
import org.springframework.data.repository.CrudRepository

interface SubtaskRepository : CrudRepository<Subtask, Long> {
    fun findAllByParentId(taskId: Long): List<Subtask>
}