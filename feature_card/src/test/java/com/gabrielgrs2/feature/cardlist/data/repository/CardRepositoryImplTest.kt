package com.gabrielgrs2.feature.cardlist.data.repository

import com.gabrielgrs2.base.data.retrofit.ApiResult
import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.feature.cardlist.data.datasource.DataFixtures
import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.AllCardsResponse
import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.toDomainModel
import com.gabrielgrs2.feature.cardlist.data.datasource.api.service.CardRetrofitService
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class CardRepositoryImplTest {

    private val mockService: CardRetrofitService = mockk()

    private val cut = CardRepositoryImpl(mockService)

    @Test
    fun `searchAllCards handles api success and returns cards`() {
        // given
        coEvery { mockService.searchAllCards() } returns ApiResult.Success(
            DataFixtures.ApiResponse.getAllCardsResponse()
        )

        // when
        val actual = runBlocking { cut.searchAllCards() }

        // then
        val cardsDomain: ArrayList<Card> = arrayListOf()
        val allCards = DataFixtures.ApiResponse.getAllCardsResponse()
            .groupAllResults().map {
                cardsDomain.add(it.toDomainModel())
            }

        actual shouldBeEqualTo Result.Success(cardsDomain)
    }

    @Test
    fun `searchAllCards handles api error `() {
        // given
        coEvery {
            mockService.searchAllCards()
        } returns mockk<ApiResult.Error<AllCardsResponse>>()

        // when
        val actual = runBlocking { cut.searchAllCards() }

        // then
        actual shouldBeEqualTo Result.Failure()
    }
}
