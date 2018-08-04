package infrastructure.repository

import domain.model.billing.BillingEvent
import domain.model.billing.BillingEventRepository

class BillingEventRepositoryImpl : BillingEventRepository {
    override fun save(event: BillingEvent) {
        events.add(event)
    }

    override fun findAllEvents(): List<BillingEvent> {
        return events
    }

    companion object {
        val events = mutableListOf<BillingEvent>()
    }
}