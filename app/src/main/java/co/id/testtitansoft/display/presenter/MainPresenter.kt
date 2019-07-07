package co.id.testtitansoft.display.presenter

import co.id.testtitansoft.display.contract.MainContract
import co.id.testtitansoft.display.repository.MainRepository
import co.id.testtitansoft.utils.SchedulersFacade
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(
    val view: MainContract.View,
    val repository: MainRepository
) {

    val displosable = CompositeDisposable()
    val schedulersFacade = SchedulersFacade()

    fun getBalance(id: Int) {
        view.showLoading()
        displosable.add(
            repository.getUserBalance(id)
                .observeOn(schedulersFacade.ui())
                .subscribeOn(schedulersFacade.io())
                .subscribe(
                    { response ->
                        view.showBalance(response)
                        view.hideLoading()
                    },
                    { error ->
                        view.doOnError(error.message)
                        view.hideLoading()

                    }
                )
        )
    }

    fun getBalance2(id: Int) {
        displosable.add(
            repository.getUserBalance2(id)
                .observeOn(schedulersFacade.ui())
                .subscribeOn(schedulersFacade.io())
                .subscribe(
                    { response ->
                        view.showBalance(response)
                        view.hideLoading()
                    },
                    { error ->
                        view.doOnError(error.message)
                        view.hideLoading()

                    }
                )
        )
    }

    fun getUserRank() {
        displosable.add(
            repository.getUserRank()
                .observeOn(schedulersFacade.ui())
                .subscribeOn(schedulersFacade.io())
                .subscribe(
                    { response ->
                        view.showRank(response)
                        view.hideLoading()
                    },
                    { error ->
                        view.doOnError(error.message)
                        view.hideLoading()
                    }
                )
        )
    }
}