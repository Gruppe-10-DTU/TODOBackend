package com.example.todobackend.controller

import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import com.example.todobackend.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.util.*

@Controller
@RequestMapping("tasks")
class TaskController(
        private val taskService: TaskService
) {
    @GetMapping("/")
    fun get(@RequestParam(value = "completionDate", required = false) date: Date?,
            @RequestParam(value = "priority", required = false) prio: Priority?,
            @RequestParam(value = "completion", required = false) completed: Boolean?
            ): List<Task> {

        return taskService.getAllByParams(date, prio, completed)
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