package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.base.presentation.viewmodel.BaseViewModel
import com.gabrielgrs2.feature.cardlist.domain.usecase.GetAllCardsListUseCase
import kotlinx.coroutines.launch

internal class CardListViewModel(
    private val navManager: NavManager,
    private val getCardListUseCase: GetAllCardsListUseCase,
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

    fun onCardClicked(
        image: String,
        name: String,
        flavor: String,
        description: String,
        cardSet: String,
        type: String,
        rarity: String,
        faction: String,
        cost: Int,
        attack: Int,
        health: Int,
    ) {
        val navDirections =
            CardListFragmentDirections.actionCardListToCardDetail(
                image = image,
                name = name,
                flavor = flavor,
                description = description,
                cardSet = cardSet,
                type = type,
                rarity = rarity,
                faction = faction,
                cost = cost,
                attack = attack,
                health = health
            )

        navManager.navigate(navDirections)
    }
}
