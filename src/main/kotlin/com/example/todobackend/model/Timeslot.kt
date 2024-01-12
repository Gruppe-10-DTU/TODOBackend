package com.example.todobackend.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.springframework.data.annotation.Id
import java.time.LocalTime

@Entity
@Table(name = "timeslot")
class Timeslot(
    @jakarta.persistence.Id @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timeslot_id")
    var id: Long?,

    @Column(name = "name")
    var name: String,

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "start_time")
    var start: LocalTime,

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "end_time")
    var end: LocalTime,

    @OneToMany(mappedBy = "timeslot")
    var tasks: List<Task>
)