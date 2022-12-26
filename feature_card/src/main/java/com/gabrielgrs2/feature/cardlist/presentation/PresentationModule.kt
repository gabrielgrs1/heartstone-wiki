package com.gabrielgrs2.feature.cardlist.presentation

import com.gabrielgrs2.feature.cardlist.presentation.screen.list.CardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val presentationModule = module {

    viewModelOf(::CardListViewModel)
}
