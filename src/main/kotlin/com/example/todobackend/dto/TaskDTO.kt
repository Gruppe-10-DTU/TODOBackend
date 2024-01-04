package com.example.todobackend.dto

import com.example.todobackend.model.Priority
import java.sql.Timestamp

data class TaskDTO (
    var title : String,
    var completed : Boolean,
    var deadline : Timestamp,
    var priority : Priority
)