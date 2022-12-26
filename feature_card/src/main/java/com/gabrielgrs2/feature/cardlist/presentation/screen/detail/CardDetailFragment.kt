package com.gabrielgrs2.feature.cardlist.presentation.screen.detail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.gabrielgrs2.base.presentation.activity.BaseFragment
import com.gabrielgrs2.base.presentation.ext.toast
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature_cardlist.R
import com.gabrielgrs2.feature_cardlist.databinding.FragmentCardDetailBinding
import com.squareup.picasso.Picasso
import org.koin.androidx.navigation.koinNavGraphViewModel


class CardDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentCardDetailBinding
    private val viewModel: CardDetailViewModel by koinNavGraphViewModel(R.id.cardNavGraph)
    private val args: CardDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeUiState()
        viewModel.onEnter(args)
        bindBackButton()
    }

    private fun observeUiState() {
        viewModel.uiState.observe(requireActivity()) {
            when (it) {
                is UiState.Content -> bindCard(it.card)
                is UiState.Error -> handleError()
            }
        }
    }

    private fun handleError() {
        requireActivity().toast(R.string.show_details_error)
    }

    private fun bindBackButton() {
        binding.cardBackIv.setOnClickListener { viewModel.onBackPressed() }
    }

    private fun bindCard(card: Card) {
        binding.cardNameTv.text = card.name
        binding.cardDescriptionTv.text = Html.fromHtml(card.description)
        bindCardFlavor(card.flavor)
        bindCardSet(card.cardSet)
        bindCardFaction(card.faction)
        bindCardType(card.type)
        bindRaritySet(card.rarity)
        bindCardAttack(card.attack)
        bindCardHealth(card.health)
        bindCardCost(card.cost)
        bindCardImage(card.image)
    }

    private fun bindCardFlavor(flavor: String) {
        if (flavor.isNotEmpty()) {
            binding.cardFlavorTv.text = flavor
        } else {
            binding.cardFlavorTv.visibility = View.GONE
        }
    }

    private fun bindCardImage(image: String) {
        if (image.isNotEmpty()) {
            Picasso
                .with(context)
                .load(image)
                .placeholder(R.drawable.progress_animation)
                .into(binding.cardImageIv)
        }
    }

    private fun bindCardSet(cardSet: String) {
        if (cardSet.isNotEmpty()) {
            binding.cardSetTv.text =
                resources.getString(R.string.card_detail_set_label, cardSet)
        } else {
            binding.cardSetTv.text =
                 resources.getString(
                    R.string.card_detail_set_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }

    private fun bindCardFaction(faction: String) {
        if (faction.isNotEmpty()) {
            binding.cardFactionTv.text =
                 resources.getString(R.string.card_detail_faction_label, faction)
        } else {
            binding.cardFactionTv.text =
                 resources.getString(
                    R.string.card_detail_faction_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }

    private fun bindCardType(type: String) {
        if (type.isNotEmpty()) {
            binding.cardTypeTv.text =
                 resources.getString(R.string.card_detail_type_label, type)
        } else {
            binding.cardTypeTv.text =
                 resources.getString(
                    R.string.card_detail_type_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }

    private fun bindRaritySet(rarity: String) {
        if (rarity.isNotEmpty()) {
            binding.cardRarityTv.text =
                 resources.getString(R.string.card_detail_rarity_label, rarity)

        } else {
            binding.cardRarityTv.text =
                 resources.getString(
                    R.string.card_detail_rarity_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }

    private fun bindCardCost(cost: Int) {
        if (cost > 0) {
            binding.cardCoastTv.text =
                 resources.getString(R.string.card_detail_cost_label, cost.toString())
        } else {
            binding.cardCoastTv.text =
                 resources.getString(
                    R.string.card_detail_cost_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }

    private fun bindCardHealth(health: Int) {
        if (health > 0) {
            binding.cardHealthTv.text =
                 resources.getString(
                    R.string.card_detail_health_label,
                    health.toString()
                )
        } else {
            binding.cardHealthTv.text =
                 resources.getString(
                    R.string.card_detail_health_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }

    private fun bindCardAttack(attack: Int) {
        if (attack > 0) {
            binding.cardAttackTv.text =
                 resources.getString(
                    R.string.card_detail_attack_label,
                    attack.toString()
                )
        } else {
            binding.cardAttackTv.text =
                 resources.getString(
                    R.string.card_detail_attack_label,
                    Html.fromHtml( resources.getString(R.string.no_application))
                )
        }
    }
}