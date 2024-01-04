package com.example.todobackend.service

import com.example.todobackend.dto.TaskDTO
import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import com.example.todobackend.repository.TaskRepository
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class TaskService(
        private val taskRepository: TaskRepository
) {
    fun getAllByParams(date: Timestamp?, prio: Priority?, completed: Boolean?): List<Task> {
        return taskRepository.findAllByParameters(date, prio, completed)
    }

    fun getById(id: Long): Task {
        return taskRepository.findById(id).get()
    }

    fun addTask(dto: TaskDTO): Task {
        return taskRepository.save(Task(dto.title, dto.completed, dto.deadline, dto.priority, null, emptyList()))
    }

    fun editTask(id: Long, dto: TaskDTO): Task {
        val task = taskRepository.findById(id).get()
        task.deadline = dto.deadline
        task.completed = dto.completed
        task.priority = dto.priority
        task.title = dto.title
        return taskRepository.save(task)
    }

    fun deleteTask(id : Long) {
        taskRepository.deleteById(id)
    }
}