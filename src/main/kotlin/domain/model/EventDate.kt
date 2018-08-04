package domain.model

import java.time.LocalDateTime

data class EventDate(private val calculatedOn: LocalDateTime) {

    fun year(): Int {
        return calculatedOn.year
    }

    fun month(): Int {
        return calculatedOn.monthValue
    }

    fun day(): Int {
        return calculatedOn.dayOfMonth
    }

    fun hour(): Int {
        return calculatedOn.hour
    }
    fun minute(): Int {
        return calculatedOn.minute
    }

    fun second(): Int {
        return calculatedOn.second
    }

}
