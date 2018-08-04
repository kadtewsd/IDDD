package domain.model

import domain.model.billing.BillingCalculationStartSubscriber
import domain.model.billing.BillingCalculationStarted
import domain.model.billing.BillingEventRepository
import infrastructure.repository.BillingEventRepositoryImpl
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class DomainEventPublisherTest {

    @Test
    fun testSubScribe() {
        DomainEventPublisher.instance().subscribe(BillingCalculationStartSubscriber())
        val repository: BillingEventRepository = BillingEventRepositoryImpl()
        assertEquals(repository.findAllEvents().size, 0)

        val current: LocalDateTime = LocalDateTime.now()
        DomainEventPublisher.instance().publish(BillingCalculationStarted(current))

        assertEquals(repository.findAllEvents().size, 1)
        val event =  repository.findAllEvents()[0]
        assertEquals(event.javaClass, BillingCalculationStarted::class.javaObjectType)
        assertEquals((event as BillingCalculationStarted).currentMonth().year(), current.year)

        assertEquals(event.currentMonth().month(), current.monthValue)
        assertEquals(event.currentMonth().day(), current.dayOfMonth)
        assertEquals(event.currentMonth().hour(), current.hour)
        assertEquals(event.currentMonth().minute(), current.minute)
        assertEquals(event.currentMonth().second(), current.second)

        DomainEventPublisher.instance().reset()
    }

}