package com.gabrielgrs2.feature.cardlist.presentation.screen.detail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.gabrielgrs2.base.presentation.activity.BaseFragment
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
        bindCard()
        bindBackButton()

    }

    private fun bindBackButton() {
        binding.cardBackIv.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun bindCard() {
        binding.cardNameTv.text = args.name
        binding.cardDescriptionTv.text = Html.fromHtml(args.description)
        bindCardFlavor()
        bindCardSet()
        bindCardFaction()
        bindCardType()
        bindRaritySet()
        bindCardAttack()
        bindCardHelth()
        bindCardCost()
        bindCardImage()
    }

    private fun bindCardFlavor() {
        if (args.cardSet.isNotEmpty()) {
            binding.cardFlavorTv.text = args.flavor
        } else {
            binding.cardFlavorTv.visibility = View.GONE
        }

    }

    private fun bindCardImage() {
        if (args.image.isNotEmpty()) {
            Picasso
                .with(context)
                .load(args.image)
                .placeholder(R.drawable.progress_animation)
                .into(binding.cardImageIv)
        }
    }

    private fun bindCardSet() {
        if (args.cardSet.isNotEmpty()) {
            binding.cardSetTv.text =
                requireContext().getString(R.string.card_detail_set_label, args.cardSet)
        } else {
            binding.cardSetTv.text =
                requireContext().getString(
                    R.string.card_detail_set_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )
        }
    }

    private fun bindCardFaction() {
        if (args.faction.isNotEmpty()) {
            binding.cardFactionTv.text =
                requireContext().getString(R.string.card_detail_faction_label, args.faction)
        } else {
            binding.cardFactionTv.text =
                requireContext().getString(
                    R.string.card_detail_faction_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )
        }
    }

    private fun bindCardType() {
        if (args.type.isNotEmpty()) {
            binding.cardTypeTv.text =
                requireContext().getString(R.string.card_detail_type_label, args.type)
        } else {
            binding.cardTypeTv.text =
                requireContext().getString(
                    R.string.card_detail_type_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )
        }
    }

    private fun bindRaritySet() {
        if (args.rarity.isNotEmpty()) {
            binding.cardRarityTv.text =
                requireContext().getString(R.string.card_detail_rarity_label, args.rarity)

        } else {
            binding.cardRarityTv.text =
                requireContext().getString(
                    R.string.card_detail_rarity_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )
        }
    }

    private fun bindCardCost() {
        if (args.cost > 0) {
            binding.cardCoastTv.text =
                requireContext().getString(R.string.card_detail_cost_label, args.cost.toString())

        } else {
            binding.cardCoastTv.text =
                requireContext().getString(
                    R.string.card_detail_cost_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )
        }
    }

    private fun bindCardHelth() {
        if (args.health > 0) {
            binding.cardHealthTv.text =
                requireContext().getString(
                    R.string.card_detail_health_label,
                    args.health.toString()
                )
        } else {
            binding.cardHealthTv.text =
                requireContext().getString(
                    R.string.card_detail_health_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )

        }
    }

    private fun bindCardAttack() {
        if (args.attack > 0) {
            binding.cardAttackTv.text =
                requireContext().getString(
                    R.string.card_detail_attack_label,
                    args.attack.toString()
                )
        } else {
            binding.cardAttackTv.text =
                requireContext().getString(
                    R.string.card_detail_attack_label,
                    Html.fromHtml(requireContext().getString(R.string.no_application))
                )
        }
    }
}