package com.example.todobackend.model

import jakarta.persistence.*
import org.springframework.data.annotation.Id

@Entity
@Table(name = "subtask")
class Subtask(
        @Column(name = "title")
        var title : String,

        @Column(name = "completed")
        var completed : Boolean,

        @ManyToOne
        @JoinColumn(name = "task_id")
        var parent : Task,

        @jakarta.persistence.Id @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "subtask_id")
        var id: Long
)