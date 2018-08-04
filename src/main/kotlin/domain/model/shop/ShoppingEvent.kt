package domain.model.shop

import domain.model.DomainEvent
import domain.model.Money
import domain.model.identity.GroupUser
import domain.model.identity.Identities
import java.time.LocalDateTime
import java.time.LocalTime

abstract class ShoppingEvent(val identities: Identities, val money: Money, private val occured: LocalDateTime) : DomainEvent {

    override fun occuredOn(): LocalDateTime {
        return this.occured
    }

    override fun occuredTime(): LocalTime {
        return this.occured.toLocalTime()
    }

    fun identityType(): GroupUser {
        return identities.identityType()
    }
}