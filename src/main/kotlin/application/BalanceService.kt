package application

import domain.model.Money
import domain.model.financial.AccountRepository
import domain.model.financial.BalanceNotMatchedException
import infrastructure.repository.AccountRepositoryImpl

class BalanceService {

    val repository: AccountRepository = AccountRepositoryImpl()

    fun doBilling(accountNumber: String, money: Money) {

        val account = repository.findByAccountNo(accountNumber)

        if (account.balance < money.value) {
            throw BalanceNotMatchedException("残金より大きな金額を請求できません")
        }

        repository.save(account.copy(balance = account.balance - money.value));

    }
}
