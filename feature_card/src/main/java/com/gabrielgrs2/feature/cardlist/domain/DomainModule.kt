package com.gabrielgrs2.feature.cardlist.domain

import com.gabrielgrs2.feature.cardlist.domain.usecase.GetAllCardsListUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {

    singleOf(::GetAllCardsListUseCase)
}
