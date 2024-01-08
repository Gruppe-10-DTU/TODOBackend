package com.example.todobackend.model

import com.example.todobackend.dto.TimeslotDTO
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.data.annotation.Id
import java.sql.Timestamp

@Entity
@Table(name = "task")
class Task(
        @Column(name = "title")
        var title : String,

        @Column(name = "completed")
        var isCompleted : Boolean,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @Column(name = "completion")
        var deadline : Timestamp,

        @Column(name = "priority")
        var priority : Priority,

        @jakarta.persistence.Id @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "task_id")
        var id: Long?,

        @OneToMany(mappedBy = "parent", orphanRemoval = true)
        var subtasks: List<Subtask>,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "timeslot_id")
        var timeslot : Timeslot?
)