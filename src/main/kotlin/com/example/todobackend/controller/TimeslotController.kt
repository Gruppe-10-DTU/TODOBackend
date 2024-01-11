package com.example.todobackend.controller

import com.example.todobackend.dto.TimeslotDTO
import com.example.todobackend.model.Timeslot
import com.example.todobackend.service.TimeslotService
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("timeslots")
@ResponseBody
class TimeslotController(
    private val timeslotService: TimeslotService
) {
    @GetMapping
    fun get(): ResponseEntity<List<Timeslot>> {
        return ResponseEntity.ok(timeslotService.getAll())
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") timeslotId: Long
    ): ResponseEntity<Timeslot> {
        val timeslot = timeslotService.findById(timeslotId) ?:
        return ResponseEntity.notFound().build()

        return ResponseEntity.ok(timeslot)
    }

    @PostMapping
    fun post(@RequestBody dto: TimeslotDTO
    ): ResponseEntity<Timeslot> {
        val timeslot: Timeslot
        try {
            timeslot = timeslotService.addTimeslot(dto)
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
        return ResponseEntity.ok(timeslot)
    }

    @PutMapping("/{id}")
    fun editTimeslot(@PathVariable("id") timeslotId: Long,
                    @RequestBody dto: TimeslotDTO
    ) : ResponseEntity<Timeslot> {
        val timeslot: Timeslot
        try {
            timeslot = timeslotService.editTimeslot(timeslotId, dto)
        } catch (exception: NoSuchElementException) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(timeslot)
    }

    @DeleteMapping("/{id}")
    fun deleteTimeslot(@PathVariable("id") timeslotId: Long) : ResponseEntity<Void> {
        timeslotService.deleteTimeslot(timeslotId)
        return ResponseEntity.noContent().build()
    }
}