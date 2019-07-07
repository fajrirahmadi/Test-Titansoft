package co.id.testtitansoft.restapi.adapter

import co.id.testtitansoft.restapi.BaseRestApiAdapter
import co.id.testtitansoft.restapi.TitanRestApi

class RestApiAdapter : BaseRestApiAdapter() {

    companion object {
        fun getTitanRestApi(): TitanRestApi {
            restAdapter = getRestAdapter("http://34.66.85.90/")
            return restAdapter.create(TitanRestApi::class.java)
        }
    }
}