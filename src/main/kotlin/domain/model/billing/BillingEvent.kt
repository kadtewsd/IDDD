package domain.model.billing

import domain.model.DomainEvent
import java.time.LocalDateTime
import java.time.LocalTime

abstract class BillingEvent(private val occured: LocalDateTime) : DomainEvent {

    override fun occuredOn(): LocalDateTime {
        return this.occured
    }

    override fun occuredTime(): LocalTime {
        return this.occured.toLocalTime()
    }
}