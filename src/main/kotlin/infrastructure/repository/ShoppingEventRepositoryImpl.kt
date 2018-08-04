package infrastructure.repository

import domain.model.shop.ShoppingEvent
import domain.model.shop.ShoppingEventRepository

class ShoppingEventRepositoryImpl : ShoppingEventRepository {
    override fun save(event: ShoppingEvent) {
        events.add(event)
    }

    override fun findAllEvents(): List<ShoppingEvent> {
        return events
    }

    companion object {
        val events = mutableListOf<ShoppingEvent>()
    }
}