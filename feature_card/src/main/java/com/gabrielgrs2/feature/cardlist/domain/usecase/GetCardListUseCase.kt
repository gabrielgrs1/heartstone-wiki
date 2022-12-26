package com.gabrielgrs2.feature.cardlist.domain.usecase

import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature.cardlist.domain.repository.CardRepository

internal class GetCardListUseCase(
    private val cardRepository: CardRepository,
) {

    suspend operator fun invoke(): Result<List<Card>> {
        return cardRepository.searchAllCards()
    }
}
