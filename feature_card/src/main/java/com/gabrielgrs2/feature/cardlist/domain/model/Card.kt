package com.gabrielgrs2.feature.cardlist.domain.model

data class Card(
    val image: String? = "",
    val name: String? = "",
    val flavor: String? = "",
    val description: String? = "",
    val cardSet: String? = "",
    val type: String? = "",
    val rarity: String? = "",
    val faction: String? = "",
    val cost: Int = 0,
    val attack: Int = 0,
    val health: Int = 0
)