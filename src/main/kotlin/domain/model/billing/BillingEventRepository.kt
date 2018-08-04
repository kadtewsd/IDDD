package domain.model.billing

interface BillingEventRepository {

    fun save(event: BillingEvent)
    fun findAllEvents(): List<BillingEvent>
}
