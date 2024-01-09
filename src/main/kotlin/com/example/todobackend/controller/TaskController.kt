package com.example.todobackend.controller

import com.example.todobackend.dto.TaskDTO
import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import com.example.todobackend.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.sql.Timestamp

@Controller
@RequestMapping("tasks")
@ResponseBody
class TaskController(
        private val taskService: TaskService
) {
    @GetMapping
    fun get(@RequestParam(value = "completionDate", required = false) date: Timestamp?,
            @RequestParam(value = "priority", required = false) prio: Priority?,
            @RequestParam(value = "completion", required = false) completed: Boolean?
            ): ResponseEntity<List<Task>> {

        return ResponseEntity.ok(taskService.getAllByParams(date, prio, completed))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): ResponseEntity<Task> {
        val task = taskService.getById(id)

        if (task.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(task.get())
    }

    @PostMapping
    fun addNewTask(@RequestBody dto: TaskDTO): ResponseEntity<Task> {
        val task: Task

        try {
             task = taskService.addTask(dto)
        } catch (exception: Exception){
            return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(task)
    }

    @PutMapping("/{id}")
    fun editTask(@PathVariable("id") id: Long,
                 @RequestBody dto: TaskDTO): ResponseEntity<Task> {
        val task: Task
        try {
            task = taskService.editTask(id, dto)
        } catch (exception: NoSuchElementException) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(task)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Long): ResponseEntity<Void> {
        taskService.deleteTask(id)
        return ResponseEntity.noContent().build()
    }

}