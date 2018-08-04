package domain.model.financial

data class Account(val number: AccountNumber, val bank: Bank, val balance: Int)