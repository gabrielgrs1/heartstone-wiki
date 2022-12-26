package com.gabrielgrs2.feature.cardlist.domain.usecase

import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.feature.cardlist.data.repository.CardRepositoryImpl
import com.gabrielgrs2.feature.cardlist.domain.DomainFixtures
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class GetCardListUseCaseTest {

    private val mockCardRepository: CardRepositoryImpl = mockk()

    private val cut = GetCardListUseCase(mockCardRepository)

    @Test
    fun `return list of cards`() {
        // given
        val cards = listOf(DomainFixtures.getCard(), DomainFixtures.getCard())
        coEvery { mockCardRepository.searchAllCards() } returns Result.Success(cards)

        // when
        val actual = runBlocking { cut() }

        // then
        actual shouldBeEqualTo Result.Success(cards)
    }

    @Test
    fun `return error when repository throws an exception`() {
        // given
        val resultFailure = mockk<Result.Failure>()
        coEvery { mockCardRepository.searchAllCards() } returns resultFailure

        // when
        val actual = runBlocking { cut() }

        // then
        actual shouldBeEqualTo resultFailure
    }
}
