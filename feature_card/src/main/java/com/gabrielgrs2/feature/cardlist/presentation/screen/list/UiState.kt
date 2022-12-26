package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import com.gabrielgrs2.base.presentation.viewmodel.BaseState
import com.gabrielgrs2.feature.cardlist.domain.model.Card

open class UiState : BaseState {
    data class Content(val cards: List<Card>) : UiState()
    object ShowLoading : UiState()
    object Error : UiState()
}