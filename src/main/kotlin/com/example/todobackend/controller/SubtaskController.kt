package com.example.todobackend.controller

import com.example.todobackend.model.Subtask
import com.example.todobackend.service.SubtaskService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("tasks/{id}/subtasks")
@ResponseBody
class SubtaskController(
        private val subtaskService: SubtaskService
) {

    @GetMapping
    fun get(@PathVariable("id") id: Long): List<Subtask> {
        return subtaskService.getAllSubtasks(id)
    }

    @PostMapping
    fun post(@PathVariable("id") id: Long,
             @RequestBody subtask: Subtask): Subtask {
        return subtaskService.addSubtask(id, subtask)
    }

    @PutMapping("/{subtaskId}")
    fun editSubtask(@PathVariable("subtaskId") subtaskId: Long,
                    @RequestBody subtask: Subtask) : Subtask {
        return subtaskService.editSubtask(subtaskId, subtask)
    }

    @DeleteMapping("/{subtaskId}")
    fun deleteSubtask(@PathVariable("subtaskId") subtaskId: Long) {
        subtaskService.deleteSubtask(subtaskId)
    }
}