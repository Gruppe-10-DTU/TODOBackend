package com.example.todobackend.dto

import java.time.LocalTime

data class TimeslotDTO (
    val name: String,
    val start: LocalTime,
    val end: LocalTime
)
