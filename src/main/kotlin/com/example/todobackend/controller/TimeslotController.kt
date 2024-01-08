package com.example.todobackend.controller

import com.example.todobackend.dto.TimeslotDTO
import com.example.todobackend.model.Timeslot
import com.example.todobackend.service.TimeslotService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("timeslots")
@ResponseBody
class TimeslotController(
    private val timeslotService: TimeslotService
) {
    @GetMapping
    fun get(): List<Timeslot> {
        return timeslotService.getAll()
    }

    @PostMapping
    fun post(@RequestBody dto: TimeslotDTO
    ): Timeslot {
        return timeslotService.addTimeslot(dto)
    }

    @PutMapping("/{id}")
    fun editTimeslot(@PathVariable("id") timeslotId: Long,
                    @RequestBody dto: TimeslotDTO
    ) : Timeslot {
        return timeslotService.editTimeslot(timeslotId, dto)
    }

    @DeleteMapping("/{id}")
    fun deleteTimeslot(@PathVariable("id") timeslotId: Long) {
        timeslotService.deleteTimeslot(timeslotId)
    }
}