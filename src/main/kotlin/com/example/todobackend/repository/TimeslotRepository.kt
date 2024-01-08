package com.example.todobackend.repository

import com.example.todobackend.model.Timeslot
import org.springframework.data.repository.CrudRepository

interface TimeslotRepository : CrudRepository<Timeslot, Long>{

}