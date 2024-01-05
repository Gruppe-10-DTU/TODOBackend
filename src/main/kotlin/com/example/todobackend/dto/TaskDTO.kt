package com.example.todobackend.dto

import com.example.todobackend.model.Priority
import java.sql.Timestamp

data class TaskDTO (
    val title : String,
    val isCompleted : Boolean,
    val deadline : Timestamp,
    val priority : Priority
)