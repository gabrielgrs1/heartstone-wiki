package com.gabrielgrs2.feature.cardlist.data.datasource.api.service

import com.gabrielgrs2.base.data.retrofit.ApiResult
import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.AllCardsResponse
import retrofit2.http.GET

internal interface CardRetrofitService {

    @GET("/cards")
    suspend fun searchAllCards(): ApiResult<AllCardsResponse>
}
