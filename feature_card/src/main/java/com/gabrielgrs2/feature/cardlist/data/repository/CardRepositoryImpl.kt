package com.gabrielgrs2.feature.cardlist.data.repository

import com.gabrielgrs2.base.data.retrofit.ApiResult
import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.toDomainModel
import com.gabrielgrs2.feature.cardlist.data.datasource.api.service.CardRetrofitService
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature.cardlist.domain.repository.CardRepository
import timber.log.Timber

internal class CardRepositoryImpl(
    private val cardRetrofitService: CardRetrofitService
) : CardRepository {

    override suspend fun searchAllCards(): Result<List<Card>> =
        when (val apiResult = cardRetrofitService.searchAllCards()) {
            is ApiResult.Success -> {
                val cards: ArrayList<Card> = arrayListOf()

                apiResult.data
                    .groupAllResults().map {
                        cards.add(it.toDomainModel())
                    }

                Result.Success(cards)
            }
            is ApiResult.Error -> {
                Result.Failure()
            }
            is ApiResult.Exception -> {
                Timber.e(apiResult.throwable)
                Result.Failure(apiResult.throwable)
            }
        }
}
