package com.example.todobackend.service

import com.example.todobackend.dto.SubtaskDTO
import com.example.todobackend.model.Subtask
import com.example.todobackend.repository.SubtaskRepository
import com.example.todobackend.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class SubtaskService(
        private val taskRepository: TaskRepository,
        private val subtaskRepository: SubtaskRepository
) {
    fun getAllSubtasks(taskId: Long): List<Subtask> {
        return subtaskRepository.findAllByParentId(taskId)
    }

    fun addSubtask(id: Long, dto: SubtaskDTO): Subtask {
        val task = taskRepository.findById(id).get()
        return subtaskRepository.save(Subtask(dto.title, dto.completed, task, null))
    }

    fun editSubtask(subtaskId: Long, dto: SubtaskDTO): Subtask {
        val subtask = subtaskRepository.findById(subtaskId).get()
        subtask.title = dto.title
        subtask.completed = dto.completed
        return subtaskRepository.save(subtask)
    }

    fun deleteSubtask(id : Long) {
        subtaskRepository.deleteById(id)
    }
}