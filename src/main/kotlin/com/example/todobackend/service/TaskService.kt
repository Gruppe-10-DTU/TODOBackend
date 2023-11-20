package com.example.todobackend.service

import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import com.example.todobackend.repository.TaskRepository
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class TaskService(
        private val taskRepository: TaskRepository
) {
    fun getAllByParams(date: Date?, prio: Priority?, completed: Boolean?): List<Task> {
        return taskRepository.findAllByParameters(date, prio, completed)
    }

    fun getById(id: Long): Task {
        return taskRepository.findById(id).get()
    }

    fun addTask(task: Task): Task {
        return taskRepository.save(task)
    }

    fun editTask(id: Long, task: Task): Task {
        task.id = id
        return taskRepository.save(task)
    }

    fun deleteTask(id : Long) {
        taskRepository.deleteById(id)
    }
}