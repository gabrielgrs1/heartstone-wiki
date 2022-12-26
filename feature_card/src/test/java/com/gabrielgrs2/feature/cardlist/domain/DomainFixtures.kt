package com.gabrielgrs2.feature.cardlist.domain

import com.gabrielgrs2.feature.cardlist.domain.model.Card

object DomainFixtures {

    internal fun getCard(
        name: String = "name",
        image: String = "image",
        flavor: String = "flavor",
        description: String = "description",
        cardSet: String = "cardSet",
        type: String = "type",
        rarity: String = "rarity",
        faction: String = "faction",
        cost: Int = 3,
        attack: Int = 5,
        health: Int = 2
    ): Card =
        Card(image, name, flavor, description, cardSet, type, rarity, faction, cost, attack, health)

}
