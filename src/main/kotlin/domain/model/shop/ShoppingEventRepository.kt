package domain.model.shop

interface ShoppingEventRepository {

    fun save(event: ShoppingEvent)
    fun findAllEvents(): List<ShoppingEvent>
}
