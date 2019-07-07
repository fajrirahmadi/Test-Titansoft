package co.id.testtitansoft.display.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import co.id.testtitansoft.R
import co.id.testtitansoft.`object`.BalanceResponse
import co.id.testtitansoft.`object`.UserRank
import co.id.testtitansoft.`object`.adapter.UserRankAdapter
import co.id.testtitansoft.display.contract.MainContract
import co.id.testtitansoft.display.presenter.MainPresenter
import co.id.testtitansoft.display.repository.MainRepository
import co.id.testtitansoft.restapi.adapter.RestApiAdapter
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun doOnError(message: String?) {

    }

    override fun showBalance(response: BalanceResponse?) {
        balanceTextView.text = response?.startBalance.toString()
        diamondBalance.text = response?.diamonBalance.toString()
    }

    override fun showBalance2(response: BalanceResponse?) {
        balanceTextView.text = response?.startBalance.toString()
        diamondBalance.text = response?.diamonBalance.toString()
    }

    override fun showRank(response: List<UserRank>?) {
        if (response != null) {
            for (user in response)
                userRankAdapter.add(UserRankAdapter(user))
        }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    private lateinit var presenter: MainPresenter
    private val userRankAdapter = FastItemAdapter<UserRankAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initPresenter()
        configureItemAdapter(rankRecycleView, userRankAdapter)
        presenter.getBalance(0)
        presenter.getUserRank()
    }

    private fun initPresenter() {
        presenter = MainPresenter(this, MainRepository(RestApiAdapter.getTitanRestApi()))
    }

    fun configureItemAdapter(
        recyclerView: RecyclerView,
        adapter: FastItemAdapter<*>
    ) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.isNestedScrollingEnabled = false
        if (!adapter.isSelectable)
            adapter.withSelectable(true)
    }

    @OnClick(R.id.balance1)
    fun balance1Clicked() {
        textBalance.text = "Balance 1"
        presenter.getBalance(0)
    }

    @OnClick(R.id.balance2)
    fun balance2Clicked() {
        textBalance.text = "Balance 2"
        presenter.getBalance2(0)
    }

    @OnClick(R.id.searchButton)
    fun searchClicked() {
        if (searchEditText.text.toString().isNotBlank())
            presenter.getBalance(searchEditText.text.toString().toInt())
    }
}
