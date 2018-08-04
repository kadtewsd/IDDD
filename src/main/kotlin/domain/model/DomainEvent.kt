package domain.model

import java.time.LocalDateTime
import java.time.LocalTime

interface DomainEvent {

    fun occuredOn(): LocalDateTime

    fun occuredTime(): LocalTime
}