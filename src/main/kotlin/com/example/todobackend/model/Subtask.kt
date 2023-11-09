package com.example.todobackend.model

import jakarta.persistence.*
import org.springframework.data.annotation.Id

@Entity
class Subtask(
        var title : String,
        var completed : Boolean,

        @ManyToOne
        @JoinColumn(name = "parent_id")
        var parent : Task,

        @jakarta.persistence.Id @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long
)