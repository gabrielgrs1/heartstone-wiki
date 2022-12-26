package com.gabrielgrs2.feature.cardlist.domain.repository

import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.base.domain.result.Result


internal interface CardRepository {

    suspend fun searchAllCards(): Result<List<Card>>
}
