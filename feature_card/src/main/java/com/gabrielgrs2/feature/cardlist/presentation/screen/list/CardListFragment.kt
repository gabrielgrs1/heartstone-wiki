package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.gabrielgrs2.base.presentation.activity.BaseFragment
import com.gabrielgrs2.base.presentation.ext.toast
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature_cardlist.R
import com.gabrielgrs2.feature_cardlist.databinding.FragmentCardListBinding
import org.koin.androidx.navigation.koinNavGraphViewModel

class CardListFragment : BaseFragment() {

    private lateinit var binding: FragmentCardListBinding
    private val viewModel: CardListViewModel by koinNavGraphViewModel(R.id.cardNavGraph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeUiState()
        viewModel.onEnter()
    }

    private fun observeUiState() {
        viewModel.uiState.observe(requireActivity()) {
            when (it) {
                is UiState.Content -> initAdapter(it.cards)
                is UiState.ShowLoading -> toggleLoading(true)
                is UiState.Error -> handleError()
            }
        }
    }

    private fun handleError() {
        toggleLoading(false)
        context?.toast(R.string.get_cards_error)
    }

    private fun toggleLoading(isVisible: Boolean) {
        binding.loadingCardListPb.isVisible = isVisible
    }

    private fun initAdapter(cardList: List<Card>) {
        toggleLoading(false)
        val cardsAdapter = CardsAdapter(cardList, requireActivity())
        binding.cardListRv.adapter = cardsAdapter
    }
}