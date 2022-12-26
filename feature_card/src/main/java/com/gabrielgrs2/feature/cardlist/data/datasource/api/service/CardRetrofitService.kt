package com.gabrielgrs2.feature.cardlist.data.datasource.api.service

import com.gabrielgrs2.base.data.retrofit.ApiResult
import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.AllCardsResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CardRetrofitService {

    @GET("/cards")
    suspend fun searchAllCards(@Query(value = "locale") locale: String = "ptBR"): ApiResult<AllCardsResponse>
}
