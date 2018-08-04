package domain.model

class DomainEventPublisher {
    companion object {

        private val subscribers: ThreadLocal<MutableList<DomainEventSubscriber>> = ThreadLocal()
        private val publishing: ThreadLocal<Boolean> = ThreadLocal.withInitial({ false })

        fun instance(): DomainEventPublisher {
            return DomainEventPublisher()
        }

    }

    fun <T : DomainEvent> publish(domainEvent: T) {
        if (publishing.get()) {
            return
        }

        try {
            publishing.set(true)
            this.handle(domainEvent);

        } finally {
            publishing.set(false)
        }
    }

    private fun <T : DomainEvent> handle(domainEvent: T) {
        if (subscribers.get() == null) {
            return
        }

        for (subscriber in subscribers.get()) {
            if (subscriber.subScribedToEventType() == domainEvent.javaClass) {
                subscriber.handle(domainEvent)
            }
        }
    }

    fun reset() {
        if (!publishing.get()) {
            subscribers.set(null)
        }
    }

    fun subscribe(subscriber: DomainEventSubscriber) {
        if (publishing.get()) {
            return
        }
        if (subscribers.get() == null) {
            subscribers.set(mutableListOf())
        }
        subscribers.get().add(subscriber)
    }
}
