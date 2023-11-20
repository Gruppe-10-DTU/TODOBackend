package com.example.todobackend.model

import jakarta.persistence.*
import org.springframework.data.annotation.Id
import java.sql.Date

@Entity
@Table(name = "task")
class Task(
        @Column(name = "title")
        var title : String,

        @Column(name = "description")
        var description : String,

        @Column(name = "completed")
        var completed : Boolean,

        @Column(name = "completion")
        var completion : Date,

        @Column(name = "priority")
        var priority : Priority,

        @jakarta.persistence.Id @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "task_id")
        var id: Long?,

        @OneToMany(mappedBy = "parent", orphanRemoval = true)
        var subtasks: List<Subtask>
)