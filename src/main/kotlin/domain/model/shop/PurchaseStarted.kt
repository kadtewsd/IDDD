package domain.model.shop

import domain.model.EventDate
import domain.model.Money
import domain.model.identity.Identities
import java.time.LocalDateTime

class PurchaseStarted(identities: Identities, money: Money, occured: LocalDateTime) : ShoppingEvent(identities, money, occured) {

    fun currentMonth(): EventDate {
        return EventDate(this.occuredOn())
    }
}