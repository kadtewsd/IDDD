package domain.model.billing

import domain.model.DomainEvent
import domain.model.DomainEventSubscriber
import infrastructure.repository.BillingEventRepositoryImpl

class BillingCalculationStartSubscriber : DomainEventSubscriber {

    companion object {
        val repository: BillingEventRepository = BillingEventRepositoryImpl()
    }

    override fun handle(event: DomainEvent) {
        val billingEvent = event as BillingCalculationStarted
        repository.save(billingEvent)
    }

    override fun subScribedToEventType(): Class<*> {
        return BillingCalculationStarted::class.javaObjectType
    }
}
