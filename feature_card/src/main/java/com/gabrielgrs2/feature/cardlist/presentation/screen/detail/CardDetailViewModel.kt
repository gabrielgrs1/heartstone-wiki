package com.gabrielgrs2.feature.cardlist.presentation.screen.detail

import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.base.presentation.viewmodel.BaseViewModel

internal class CardDetailViewModel(
    private val navManager: NavManager
) : BaseViewModel() {

    fun onBackClicked() {
        val navDirections =
            CardDetailFragmentDirections.actionCardDetailToCardList()

        navManager.navigate(navDirections)
    }
}
