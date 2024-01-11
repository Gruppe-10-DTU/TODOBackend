package com.example.todobackend.dto

import com.example.todobackend.model.Priority
import com.example.todobackend.model.Task
import com.example.todobackend.model.Timeslot
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.sql.Time
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskDTODeserializer(t: Class<TaskDTO>? = null) : StdDeserializer<TaskDTO>(t) {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): TaskDTO {
        val jsonNode: JsonNode = p.codec.readTree(p)
        val title = if (jsonNode.has("title")) jsonNode.get("title").asText() else ""
        val isCompleted = jsonNode.get("isCompleted").asBoolean()
        val deadline = Timestamp.valueOf(LocalDateTime.parse(jsonNode.get("deadline").asText(), DateTimeFormatter.ISO_DATE_TIME))
        val priority = Priority.valueOf(jsonNode.get("priority").asText())
        var taskDTO = TaskDTO(title = title, isCompleted = isCompleted, deadline = deadline, priority = priority, timeslot = null)
        if (jsonNode.has("timeslot")) {
            val timeslot = jsonNode.get("timeslot")
            val id = timeslot.get("id").asLong()
            val timeslotTitle = timeslot.get("name").asText()
            val startTime = Time.valueOf(timeslot.get("start").asText())
            val endTime = Time.valueOf(timeslot.get("end").asText())
            taskDTO = taskDTO.copy(timeslot = Timeslot(id, timeslotTitle, startTime, endTime, emptyList()))
        }
        return taskDTO
    }


}
