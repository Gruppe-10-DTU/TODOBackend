package com.example.todobackend.service

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

    fun addSubtask(id: Long, subtask: Subtask): Subtask {
        val task = taskRepository.findById(id).get()
        subtask.parent = task
        return subtaskRepository.save(subtask)
    }

    fun editSubtask(subtaskId: Long, subtask: Subtask): Subtask {
        subtask.id = subtaskId
        return subtaskRepository.save(subtask)
    }

    fun deleteSubtask(id : Long) {
        subtaskRepository.deleteById(id)
    }
}