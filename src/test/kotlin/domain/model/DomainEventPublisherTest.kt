package domain.model

import domain.DomainRegistry
import domain.model.identity.MailAddress
import domain.model.identity.User
import domain.model.shop.PurchaseStartSubscriber
import domain.model.shop.PurchaseStarted
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class DomainEventPublisherTest {

    @Test
    fun testSubScribe() {
        DomainEventPublisher.instance().subscribe(PurchaseStartSubscriber())
        val repository = DomainRegistry.instance().shoppingEventRepository()
        assertEquals(repository.findAllEvents().size, 0)

        val current: LocalDateTime = LocalDateTime.now()

        val identity = User(1, "AAAA", MailAddress("kasakaid@microsoft.com"))
        DomainEventPublisher.instance().publish(PurchaseStarted(identity, Money(1000), current))

        assertEquals(repository.findAllEvents().size, 1)
        val event =  repository.findAllEvents()[0]
        assertEquals(event.javaClass, PurchaseStarted::class.javaObjectType)
        assertEquals((event as PurchaseStarted).currentMonth().year(), current.year)

        assertEquals(event.currentMonth().month(), current.monthValue)
        assertEquals(event.currentMonth().day(), current.dayOfMonth)
        assertEquals(event.currentMonth().hour(), current.hour)
        assertEquals(event.currentMonth().minute(), current.minute)
        assertEquals(event.currentMonth().second(), current.second)

        assertEquals(
                DomainRegistry.instance().accountRepository().findByAccountNo("AAAA").balance,
                20000 - 1000
        )

        DomainEventPublisher.instance().reset()


    }

}