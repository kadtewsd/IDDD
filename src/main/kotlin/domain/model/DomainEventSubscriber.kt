package domain.model

interface DomainEventSubscriber {

    fun subScribedToEventType(): Class<*>
    fun handle(event: DomainEvent)
}

