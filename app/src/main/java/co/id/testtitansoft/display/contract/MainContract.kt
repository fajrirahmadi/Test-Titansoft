package co.id.testtitansoft.display.contract

import co.id.testtitansoft.`object`.BalanceResponse
import co.id.testtitansoft.`object`.UserRank

interface MainContract {

    interface View {
        fun doOnError(message: String?)
        fun showBalance(response: BalanceResponse?)
        fun showBalance2(response: BalanceResponse?)
        fun showRank(response: List<UserRank>?)
        fun showLoading()
        fun hideLoading()

    }
}