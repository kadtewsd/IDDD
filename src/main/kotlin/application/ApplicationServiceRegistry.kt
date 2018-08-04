package application

class ApplicationServiceRegistry {

    companion object {
        private val balanceService = BalanceService()

        fun instance(): ApplicationServiceRegistry {
            return ApplicationServiceRegistry()
        }
    }

    fun balanceService(): BalanceService {
        return balanceService
    }
}