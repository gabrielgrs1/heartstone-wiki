package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import android.content.Context
import android.text.Html
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature_cardlist.R
import com.gabrielgrs2.feature_cardlist.databinding.ItemCardBinding

class CardsViewHolder(
    itemView: View,
    private val onItemClick: ((Card) -> Unit)?
) : RecyclerView.ViewHolder(itemView) {
    private var binding: ItemCardBinding

    init {
        binding = ItemCardBinding.bind(itemView)
    }

    fun bind(
        context: Context,
        card: Card
    ) {
        binding.root.setOnClickListener { onItemClick?.invoke(card) }

        binding.cardNameTv.text = card.name
        binding.cardDescriptionTv.text = Html.fromHtml(card.description)

        if (card.attack > 0) {
            binding.cardAttackTv.visibility = View.VISIBLE
            binding.cardAttackTv.text = context.getString(R.string.card_list_attack_label, card.attack)
        } else {
            binding.cardAttackTv.visibility = View.GONE
        }

        if (card.health > 0) {
            binding.cardHealthTv.visibility = View.VISIBLE
            binding.cardHealthTv.text = context.getString(R.string.card_list_health_label, card.health)
        } else {
            binding.cardHealthTv.visibility = View.GONE
        }

        if (card.cost > 0) {
            binding.cardCoastTv.visibility = View.VISIBLE
            binding.cardCoastTv.text = card.cost.toString()
        } else {
            binding.cardCoastTv.visibility = View.GONE
        }

    }
}