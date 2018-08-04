package domain.model.financial

import domain.model.Money

class Cashing {
    fun chargeTo(account: Account, money: Money): Account {
        return account.draw(money)
    }
}