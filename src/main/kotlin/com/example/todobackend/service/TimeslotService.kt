package com.example.todobackend.service

import com.example.todobackend.dto.TimeslotDTO
import com.example.todobackend.model.Timeslot
import com.example.todobackend.repository.TimeslotRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class TimeslotService(
    private val timeslotRepository: TimeslotRepository
) {
    fun addTimeslot(dto: TimeslotDTO): Timeslot {
        return timeslotRepository.save(Timeslot(null, dto.name, dto.start, dto.end, emptyList()))
    }

    fun getAll(): List<Timeslot> {
        return timeslotRepository.findAll().toList()
    }

    fun findById(id: Long): Timeslot? {
        return timeslotRepository.findById(id).getOrNull()
    }

    @Throws(NoSuchElementException::class)
    fun editTimeslot(id: Long, dto: TimeslotDTO): Timeslot {
        val timeslot = timeslotRepository.findById(id).get()
        timeslot.name = dto.name
        timeslot.start = dto.start
        timeslot.end = dto.end
        return timeslotRepository.save(timeslot)
    }

    fun deleteTimeslot(id : Long) {
        timeslotRepository.deleteById(id)
    }
}