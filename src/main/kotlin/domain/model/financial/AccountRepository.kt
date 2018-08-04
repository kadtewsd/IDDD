package domain.model.financial

interface AccountRepository {
    fun findByAccountNo(accountNo: String): Account
    fun save(account: Account)
    fun delteBy(account: Account)
}
