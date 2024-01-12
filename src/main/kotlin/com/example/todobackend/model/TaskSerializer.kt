package com.example.todobackend.model

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.springframework.format.annotation.DateTimeFormat
import java.time.format.DateTimeFormatter

class TaskSerializer(t: Class<Task>? = null) : StdSerializer<Task>(t) {

    override fun serialize(value: Task, gen: JsonGenerator, provider: SerializerProvider) {
        val mapper: ObjectMapper = gen.codec as ObjectMapper

        gen.writeStartObject()

        gen.writeStringField("title", value.title)
        gen.writeBooleanField("isCompleted", value.isCompleted)

        gen.writeStringField("deadline", value.deadline.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        //gen.writeRawValue(mapper.writeValueAsString())

        gen.writeStringField("priority", value.priority.toString())
        value.id?.let { gen.writeNumberField("id", it) }

        gen.writeFieldName("subtasks")
        gen.writeRawValue(mapper.writeValueAsString(value.subtasks))

        if(value.timeslot != null && value.timeslot!!.id != null) {
            val timeslot: Timeslot = value.timeslot!!
            gen.writeObjectFieldStart("timeslot")
            gen.writeNumberField("id", timeslot.id!!)
            gen.writeStringField("name", timeslot.name)
            gen.writeStringField("start", timeslot.start.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
            gen.writeStringField("end", timeslot.end.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
            gen.writeArrayFieldStart("tasks")
            gen.writeEndArray()
            gen.writeEndObject()
        }
        gen.writeEndObject()
    }

}
