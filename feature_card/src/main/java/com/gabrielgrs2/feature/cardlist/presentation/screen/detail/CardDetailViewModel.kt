package com.gabrielgrs2.feature.cardlist.presentation.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.base.presentation.viewmodel.BaseViewModel
import com.gabrielgrs2.feature.cardlist.domain.model.Card

internal class CardDetailViewModel(
    private val navManager: NavManager,
) : BaseViewModel() {

    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun onEnter(args: CardDetailFragmentArgs) {
        if (checkArgsIsNotFilled(args)) {
            _uiState.value = UiState.Error
        } else {
            val card = Card(
                cardSet = args.cardSet,
                faction = args.faction,
                rarity = args.rarity,
                description = args.description,
                flavor = args.flavor,
                image = args.image,
                attack = args.attack,
                cost = args.cost,
                health = args.health,
                name = args.name,
                type = args.type
            )
            _uiState.value = UiState.Content(card)
        }
    }

    private fun checkArgsIsNotFilled(args: CardDetailFragmentArgs) = (
            args.name.isEmpty()
                    && args.image.isEmpty()
                    && args.cardSet.isEmpty()
                    && args.faction.isEmpty()
                    && args.description.isEmpty()
                    && args.rarity.isEmpty()
                    && args.type.isEmpty()
                    && args.flavor.isEmpty()
                    && args.health == 0
                    && args.cost == 0
                    && args.attack == 0
            )

    fun onBackPressed() {
        val navDirections =
            CardDetailFragmentDirections.actionCardDetailToCardList()

        navManager.navigate(navDirections)
    }
}
