package com.gabrielgrs2.feature.cardlist.presentation.screen.detail

import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.library.testutils.CoroutinesTestDispatcherExtension
import com.gabrielgrs2.library.testutils.InstantTaskExecutorExtension
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
class CardDetailViewModelTest {

    private val mockNavManager: NavManager = mockk(relaxed = true)

    private val cut = CardDetailViewModel(mockNavManager)

    @Test
    fun `onEnter emits state error on error`() = runTest {
        // given
        val mockCardDetailFragmentArgs =
            CardDetailFragmentArgs(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0,
                0,
                0
            )

        // when
        cut.onEnter(mockCardDetailFragmentArgs)

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
        val mockCardDetailFragmentArgs =
            CardDetailFragmentArgs(
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
        cut.onEnter(mockCardDetailFragmentArgs)

        // then
        advanceUntilIdle()

        cut.uiState.value shouldBeEqualTo UiState.Content(
            card = card
        )
    }

    @Test
    fun `onBackClick navigate to cards list`() {
        // given
        val navDirections = CardDetailFragmentDirections.actionCardDetailToCardList()

        // when
        cut.onBackPressed()

        // then
        coVerify { mockNavManager.navigate(navDirections) }
    }
}
