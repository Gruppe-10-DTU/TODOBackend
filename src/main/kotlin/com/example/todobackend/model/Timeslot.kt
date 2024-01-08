package com.example.todobackend.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import org.springframework.data.annotation.Id
import java.sql.Time

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
    var start: Time,

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "end_time")
    var end: Time,

    @OneToMany(mappedBy = "timeslot")
    var tasks: List<Task>
)