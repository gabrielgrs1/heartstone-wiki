package com.gabrielgrs2.feature.cardlist.presentation.screen.detail

import com.gabrielgrs2.base.presentation.viewmodel.BaseState
import com.gabrielgrs2.feature.cardlist.domain.model.Card

open class UiState : BaseState {
    data class Content(val card: Card) : UiState()
    object Error : UiState()
}