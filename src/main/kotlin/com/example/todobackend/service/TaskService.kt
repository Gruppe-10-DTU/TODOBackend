package com.example.todobackend.service

import com.example.todobackend.dto.TaskDTO
import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import com.example.todobackend.repository.TaskRepository
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class TaskService(
        private val taskRepository: TaskRepository) {
    fun getAllByParams(date: Timestamp?, prio: Priority?, completed: Boolean?): List<Task> {
        return taskRepository.findAllByParameters(date, prio, completed)
    }

    @Throws(NoSuchElementException::class)
    fun getById(id: Long): Optional<Task> {
        return taskRepository.findById(id)
    }

    fun addTask(dto: TaskDTO): Task {

        return taskRepository.save(Task(dto.title, dto.isCompleted, dto.deadline, dto.priority, 0, emptyList(), dto.timeslot))
    }

    @Throws(NoSuchElementException::class)
    fun editTask(id: Long, dto: TaskDTO): Task {
        val task = taskRepository.findById(id).get()
        task.deadline = dto.deadline
        task.isCompleted = dto.isCompleted
        task.priority = dto.priority
        task.title = dto.title
        task.timeslot = dto.timeslot

        return taskRepository.save(task)
    }

    fun deleteTask(id : Long) {
        taskRepository.deleteById(id)
    }
}