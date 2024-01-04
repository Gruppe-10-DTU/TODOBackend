package com.example.todobackend.model

import jakarta.persistence.*
import org.springframework.context.annotation.Lazy
import org.springframework.data.annotation.Id
import java.sql.Timestamp

@Entity
@Table(name = "task")
class Task(
        @Column(name = "title")
        var title : String,

        @Column(name = "completed")
        var completed : Boolean,

        @Column(name = "completion")
        var deadline : Timestamp,

        @Column(name = "priority")
        var priority : Priority,

        @jakarta.persistence.Id @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "task_id")
        var id: Long?,

        @OneToMany(mappedBy = "parent", orphanRemoval = true)
        var subtasks: List<Subtask>
)