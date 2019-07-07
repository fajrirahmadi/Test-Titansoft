package co.id.testtitansoft.display.repository

import co.id.testtitansoft.`object`.BalanceResponse
import co.id.testtitansoft.`object`.RequestBalance
import co.id.testtitansoft.`object`.UserRank
import co.id.testtitansoft.restapi.TitanRestApi
import io.reactivex.Observable

class MainRepository(var titanRestApi: TitanRestApi) {

    fun getUserBalance2(id: Int): Observable<BalanceResponse> {
        return titanRestApi.getUserBalance2(id)
    }

    fun getUserBalance(id: Int): Observable<BalanceResponse> {
        return titanRestApi.getBalance(RequestBalance(id))
    }

    fun getUserRank(): Observable<List<UserRank>> {
        return titanRestApi.getUserRank()
    }
}