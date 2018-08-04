package domain

import domain.model.financial.AccountRepository
import domain.model.shop.ShoppingEventRepository
import infrastructure.repository.AccountRepositoryImpl
import infrastructure.repository.ShoppingEventRepositoryImpl

class DomainRegistry {
    companion object {
        private val shopping: ShoppingEventRepository = ShoppingEventRepositoryImpl()
        private val account: AccountRepository = AccountRepositoryImpl()

        fun instance(): DomainRegistry {
            return DomainRegistry()
        }
    }

    fun shoppingEventRepository(): ShoppingEventRepository {
        return shopping
    }

    fun accountRepository(): AccountRepository {
        return account
    }


}

