package com.gabrielgrs2.feature.cardlist.domain.usecase

import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature.cardlist.domain.repository.CardRepository

internal class GetAllCardsListUseCase(
    private val albumRepository: CardRepository,
) {

    suspend operator fun invoke(): Result<List<Card>> {
        return albumRepository.searchAllCards()
    }
}
