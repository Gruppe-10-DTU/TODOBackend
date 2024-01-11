package com.example.todobackend.controller

import com.example.todobackend.dto.SubtaskDTO
import com.example.todobackend.model.Subtask
import com.example.todobackend.service.SubtaskService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("tasks/{id}/subtasks")
@ResponseBody
class SubtaskController(
        private val subtaskService: SubtaskService
) {

    @GetMapping
    fun get(@PathVariable("id") id: Long): ResponseEntity<List<Subtask>> {
        val subtasks = subtaskService.getAllSubtasks(id)
        return ResponseEntity.ok(subtasks)
    }

    @PostMapping
    fun post(@PathVariable("id") id: Long,
             @RequestBody dto: SubtaskDTO): ResponseEntity<Subtask> {
        val subtask : Subtask

        try {
            subtask = subtaskService.addSubtask(id, dto)
        } catch (exception: Exception) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(subtask)
    }

    @PutMapping("/{subtaskId}")
    fun editSubtask(@PathVariable("subtaskId") subtaskId: Long,
                    @RequestBody dto: SubtaskDTO, @PathVariable id: String) : ResponseEntity<Subtask> {
        val subtask: Subtask
        try {
            subtask = subtaskService.editSubtask(subtaskId, dto)
        } catch (exception: Exception) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(subtask)
    }

    @DeleteMapping("/{subtaskId}")
    fun deleteSubtask(@PathVariable("subtaskId") subtaskId: Long, @PathVariable id: String): ResponseEntity<Void> {
        subtaskService.deleteSubtask(subtaskId)

        return ResponseEntity.ok().build()
    }
}