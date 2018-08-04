package application

import domain.model.Money
import domain.model.financial.AccountRepository
import domain.model.financial.Cashing
import infrastructure.repository.AccountRepositoryImpl

class BalanceService {

    val repository: AccountRepository = AccountRepositoryImpl()
    val cashing = Cashing()

    fun doBilling(accountNumber: String, money: Int) {
        val account = repository.findByAccountNo(accountNumber)
        val cashed = cashing.chargeTo(account, Money(money))
        repository.save(cashed)

    }
}
