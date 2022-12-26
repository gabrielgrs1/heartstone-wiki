package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import com.gabrielgrs2.base.domain.result.Result
import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature.cardlist.domain.usecase.GetCardListUseCase
import com.gabrielgrs2.library.testutils.CoroutinesTestDispatcherExtension
import com.gabrielgrs2.library.testutils.InstantTaskExecutorExtension
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(InstantTaskExecutorExtension::class, CoroutinesTestDispatcherExtension::class)
class CardListViewModelTest {

    private val mockGetCardListUseCase: GetCardListUseCase = mockk()

    private val mockNavManager: NavManager = mockk(relaxed = true)

    private val cut = CardListViewModel(
        mockNavManager,
        mockGetCardListUseCase
    )

    @Test
    fun `onEnter emits state error`() = runTest {
        // given
        coEvery { mockGetCardListUseCase() } returns Result.Success(emptyList())

        // when
        cut.onEnter()

        // then
        advanceUntilIdle()

        cut.uiState.value shouldBeEqualTo UiState.Error
    }

    @Test
    fun `onEnter emits state error on failure`() = runTest {
        // given
        coEvery { mockGetCardListUseCase() } returns Result.Failure()

        // when
        cut.onEnter()

        // then
        advanceUntilIdle()

        cut.uiState.value shouldBeEqualTo UiState.Error
    }

    @Test
    fun `onEnter emits state success`() = runTest {
        // given
        val card = Card(
            image = "image",
            name = "card name",
            flavor = "flavor",
            description = "description",
            cardSet = "card set",
            type = "type",
            rarity = "rarity",
            faction = "faction",
            cost = 2,
            attack = 3,
            health = 2
        )
        val cards = listOf(card)
        coEvery { mockGetCardListUseCase() } returns Result.Success(cards)

        // when
        cut.onEnter()

        // then
        advanceUntilIdle()

        cut.uiState.value shouldBeEqualTo UiState.Content(
            cards = cards
        )
    }

    @Test
    fun `onCardClick navigate to card detail`() {
        // given
        val card = Card(
            image = "image",
            name = "card name",
            flavor = "flavor",
            description = "description",
            cardSet = "card set",
            type = "type",
            rarity = "rarity",
            faction = "faction",
            cost = 2,
            attack = 3,
            health = 2
        )

        val navDirections = CardListFragmentDirections.actionCardListToCardDetail(
            image = "image",
            name = "card name",
            flavor = "flavor",
            description = "description",
            cardSet = "card set",
            type = "type",
            rarity = "rarity",
            faction = "faction",
            cost = 2,
            attack = 3,
            health = 2
        )

        // when
        cut.onCardClicked(card)

        // then
        coVerify { mockNavManager.navigate(navDirections) }
    }
}
