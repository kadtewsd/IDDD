package domain.model.shop

import application.ApplicationServiceRegistry
import domain.DomainRegistry
import domain.model.DomainEvent
import domain.model.DomainEventSubscriber

class PurchaseStartSubscriber : DomainEventSubscriber {

    override fun handle(event: DomainEvent) {
        val billingEvent = event as PurchaseStarted
        DomainRegistry.instance().shoppingEventRepository().save(billingEvent)
        // イベントを登録したので次のアクションとなる購入金額の差し引きをアプリケーションサービスに依頼する。
        ApplicationServiceRegistry
                .instance()
                .balanceService()
                .doBilling(
                        billingEvent.identities.accountNumber,
                        billingEvent.money)
    }

    override fun subScribedToEventType(): Class<*> {
        return PurchaseStarted::class.javaObjectType
    }
}
