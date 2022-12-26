package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.base.presentation.viewmodel.BaseViewModel
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature.cardlist.domain.usecase.GetCardListUseCase
import kotlinx.coroutines.launch

internal class CardListViewModel(
    private val navManager: NavManager,
    private val getCardListUseCase: GetCardListUseCase,
) : BaseViewModel() {

    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun onEnter() {
        getCardList()
    }

    private fun getCardList() {
        viewModelScope.launch {
            _uiState.value = UiState.ShowLoading
            getCardListUseCase().also { result ->
                _uiState.value = when (result) {
                    is Result.Success -> {
                        if (result.value.isEmpty()) {
                            UiState.Error
                        } else {
                            UiState.Content(result.value)
                        }
                    }
                    is Result.Failure -> {
                        UiState.Error
                    }
                }
            }
        }
    }

    fun onCardClicked(card: Card) {
        val navDirections =
            CardListFragmentDirections.actionCardListToCardDetail(
                image = card.image,
                name = card.name,
                flavor = card.flavor,
                description = card.description,
                cardSet = card.cardSet,
                type = card.type,
                rarity = card.rarity,
                faction = card.faction,
                cost = card.cost,
                attack = card.attack,
                health = card.health
            )

        navManager.navigate(navDirections)
    }
}
