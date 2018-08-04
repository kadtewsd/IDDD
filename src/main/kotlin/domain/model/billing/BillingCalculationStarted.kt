package domain.model.billing

import java.time.LocalDateTime

class BillingCalculationStarted(occured: LocalDateTime) : BillingEvent(occured) {

    fun currentMonth(): EventDate {
        return EventDate(this.occuredOn())
    }
}