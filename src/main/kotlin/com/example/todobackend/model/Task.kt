package com.example.todobackend.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.util.*

@Entity
class Task(
        var title : String,
        var description : String,
        var completed : Boolean,
        var completion : Date,
        var priority : Priority,
        @jakarta.persistence.Id @Id
        @GeneratedValue(strategy = GenerationType.AUTO) var id: Long
)