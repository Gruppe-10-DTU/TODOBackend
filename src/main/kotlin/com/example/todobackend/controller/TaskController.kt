package com.example.todobackend.controller

import com.example.todobackend.model.Task
import com.example.todobackend.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.sql.Date

@Controller
@RequestMapping("tasks")
class TaskController(
        private val taskService: TaskService
) {
    @GetMapping("/")
    fun get(@RequestBody date: Date): List<Task> {
        return taskService.getAllByCompletionDate(date)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Task {
        return taskService.getById(id)
    }

    @PostMapping
    fun addNewTask(@RequestBody task: Task): Task {
        return taskService.addTask(task)
    }

    @PutMapping("/{id}")
    fun editTask(@PathVariable("id") id: Long,
                 @RequestBody task: Task): Task {

        return taskService.editTask(id, task)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Long) {
        taskService.deleteTask(id)
    }

}