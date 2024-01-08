package com.example.todobackend.model

import jakarta.persistence.*
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

    @Column(name = "start")
    var start: LocalTime,

    @Column(name = "end")
    var end: LocalTime,

    @OneToMany(mappedBy = "timeslot")
    var tasks: List<Subtask>
)