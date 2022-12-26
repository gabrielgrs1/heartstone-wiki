package com.gabrielgrs2.feature.cardlist.presentation.screen.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.gabrielgrs2.feature_cardlist.R

class CardsAdapter(
    private val cardList: List<Card>,
    private val context: Context
) : RecyclerView.Adapter<CardsViewHolder>() {
    var onItemClick: ((Card) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        return CardsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_card, parent, false),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(context, cardList[position])

    }

    override fun getItemCount() = cardList.size
}