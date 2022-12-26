package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature_cardlist.R
import com.gabrielgrs2.feature_cardlist.databinding.ItemCardBinding
import com.squareup.picasso.Picasso

class CardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var binding: ItemCardBinding

    init {
        binding = ItemCardBinding.bind(itemView)
    }

    fun bind(
        context: Context,
        card: Card
    ) {

        binding.repositoryNameTv.text = card.name

//        if (card.image != null && card.image.isNotEmpty()) {
//            Picasso
//                .with(context)
//                .load(card.image)
//                .placeholder(R.drawable.progress_animation)
//                .into(binding.userAvatarIv)
//        }

    }
}