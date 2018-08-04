package infrastructure.repository

import domain.model.financial.Account
import domain.model.financial.AccountNumber
import domain.model.financial.AccountRepository
import domain.model.financial.Bank

class AccountRepositoryImpl : AccountRepository {

    companion object {
        var list = mutableListOf(
                Account(AccountNumber("AAAA"), Bank(), 20000),
                Account(AccountNumber("BBBB"), Bank(), 30000),
                Account(AccountNumber("CCCC"), Bank(), 40000)
        )
    }

    override fun findByAccountNo(accountNo: String): Account {
        return list.filter({it.number.value == accountNo}).first()
    }
    override fun save(account: Account) {
        val index = if (this.index(account)== -1)  list.size else this.index(account)
        this.delteBy(account)
        list.add(index, account)

    }
    override fun delteBy(account: Account) {
        list =  list.filter({it.number.value != account.number.value}).toMutableList()
    }

    private fun index(account: Account): Int {
        var ret = -1
        for ((index, value) in list.withIndex()) {
            if (value.number.value == account.number.value) {
                ret = index
                break
            }
        }
        return ret;
    }
}