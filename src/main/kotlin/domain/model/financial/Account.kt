package domain.model.financial

import domain.model.Money

data class Account(val number: AccountNumber, val bank: Bank, val balance: Int) {

    fun draw(money: Money): Account {
        if (this.balance < money.value) {
            throw BalanceNotMatchedException("残金より大きな金額を請求できません")
        }
        return this.copy(balance = this.balance - money.value)
    }
}