package com.gabrielgrs2.feature.cardlist.data.datasource.api.response

import com.gabrielgrs2.feature.cardlist.domain.model.Card
import com.google.gson.annotations.SerializedName

internal data class AllCardsResponse(
    @SerializedName("Basic") val basic: List<CardResponse>?  = emptyList(),
    @SerializedName("Classic") val classic: List<CardResponse>?  = emptyList(),
    @SerializedName("Hall Of Fame") val hallOfFame: List<CardResponse>?  = emptyList(),
    @SerializedName("Missions") val missions: List<CardResponse>?  = emptyList(),
    @SerializedName("Naxxramas") val naxxramas: List<CardResponse>?  = emptyList(),
    @SerializedName("Goblin Vs Gnomes") val goblinVsGnomes: List<CardResponse>?  = emptyList(),
    @SerializedName("Blackrock Mountain") val blackrockMountain: List<CardResponse>?  = emptyList(),
    @SerializedName("The Grand Tournament") val theGrandTournament: List<CardResponse>?  = emptyList(),
    @SerializedName("Credits") val credits: List<CardResponse>?  = emptyList(),
    @SerializedName("Hero Skins") val heroSkins: List<CardResponse>?  = emptyList(),
    @SerializedName("Tavern Brawl") val tavernBrawl: List<CardResponse>?  = emptyList(),
    @SerializedName("The League Of Explorer") val theLeagueOfExplorer: List<CardResponse>?  = emptyList(),
    @SerializedName("Whispers of The Old Gods") val whispersOfTheOldGoods: List<CardResponse>?  = emptyList(),
    @SerializedName("One Night In Karazhan") val oneNightInKarazhan: List<CardResponse>?  = emptyList(),
    @SerializedName("Man Street Of Gadgetzan") val meanStreetsOfGadgetzan: List<CardResponse>?  = emptyList(),
    @SerializedName("Journey to Un'Goro") val journeToUnGoro: List<CardResponse>?  = emptyList(),
    @SerializedName("Knights of the Frozen Throne") val knightsOfTheFrozenThrone: List<CardResponse>?  = emptyList(),
    @SerializedName("Kobolds & Catacombs") val koboldsAndCatacombs: List<CardResponse>?  = emptyList(),
    @SerializedName("The Witchwood") val theWitchwood: List<CardResponse>?  = emptyList(),
    @SerializedName("The Boomsday Project") val theBoomsdayProject: List<CardResponse>?  = emptyList(),
    @SerializedName("Rastakhan's Rumble") val rastakhansRubmle: List<CardResponse>?  = emptyList(),
    @SerializedName("Rise of Shadows") val riseOfShadows: List<CardResponse>?  = emptyList(),
    @SerializedName("Taverns of Time") val tavernsOfTime: List<CardResponse>?  = emptyList(),
    @SerializedName("Saviors of Uldum") val saviorsOfUldum: List<CardResponse>?  = emptyList(),
    @SerializedName("Descent of Dragons") val descentOfDragons: List<CardResponse>?  = emptyList(),
    @SerializedName("Galakrond's Awakening") val galakrondsAwakeing: List<CardResponse>?  = emptyList(),
    @SerializedName("Ashes of Outland") val ashesOfOutland: List<CardResponse>?  = emptyList(),
    @SerializedName("Wild Event") val wildEvent: List<CardResponse>?  = emptyList(),
    @SerializedName("Scholomance Academy") val scholmanceAcademy: List<CardResponse>?  = emptyList(),
    @SerializedName("Battlegrounds") val battlegrounds: List<CardResponse>?  = emptyList(),
    @SerializedName("Demon Hunter Initiate") val demonHunterInitiate: List<CardResponse>?  = emptyList(),
    @SerializedName("Madness At The Darkmoon Faire") val madnessAtTheDarkmoonFaire: List<CardResponse>?  = emptyList(),
    @SerializedName("Forged in the Barrens") val forgedinBarrens: List<CardResponse>?  = emptyList(),
    @SerializedName("Legacy") val legacy: List<CardResponse>?  = emptyList(),
    @SerializedName("Core") val core: List<CardResponse>?  = emptyList(),
    @SerializedName("Vanilla") val vanilla: List<CardResponse>?  = emptyList(),
    @SerializedName("Wailing Caverns") val wailingCaverns: List<CardResponse>?  = emptyList(),
    @SerializedName("United in Stormwind") val unitedInStormwind: List<CardResponse>?  = emptyList(),
    @SerializedName("Mercenaries") val mercenaries: List<CardResponse>?  = emptyList(),
    @SerializedName("Fractured in Alterac Valley") val fracturedInAlteacValley: List<CardResponse>?  = emptyList(),
    @SerializedName("Voyage to the Sunken City") val voyageToTheSunkenCity: List<CardResponse>?  = emptyList(),
    @SerializedName("Unknown") val unknown: List<CardResponse>?  = emptyList(),
    @SerializedName("Murder at Castle Nathria") val murderAtCastleNathria: List<CardResponse>?  = emptyList(),
    @SerializedName("March of the Lich King") val marchOfTheLichKing: List<CardResponse>?  = emptyList(),
    @SerializedName("Path of Arthas") val pathOfArthas: List<CardResponse>?  = emptyList(),
) : java.io.Serializable {

    fun groupAllResults(): List<CardResponse> {
        val allCards = arrayListOf<CardResponse>()
        basic?.let { allCards.addAll(it) }
        classic?.let { allCards.addAll(it) }
        hallOfFame?.let { allCards.addAll(it) }
        missions?.let { allCards.addAll(it) }
        naxxramas?.let { allCards.addAll(it) }
        goblinVsGnomes?.let { allCards.addAll(it) }
        blackrockMountain?.let { allCards.addAll(it) }
        theGrandTournament?.let { allCards.addAll(it) }
        credits?.let { allCards.addAll(it) }
        heroSkins?.let { allCards.addAll(it) }
        tavernBrawl?.let { allCards.addAll(it) }
        theLeagueOfExplorer?.let { allCards.addAll(it) }
        whispersOfTheOldGoods?.let { allCards.addAll(it) }
        oneNightInKarazhan?.let { allCards.addAll(it) }
        meanStreetsOfGadgetzan?.let { allCards.addAll(it) }
        journeToUnGoro?.let { allCards.addAll(it) }
        knightsOfTheFrozenThrone?.let { allCards.addAll(it) }
        koboldsAndCatacombs?.let { allCards.addAll(it) }
        theWitchwood?.let { allCards.addAll(it) }
        theBoomsdayProject?.let { allCards.addAll(it) }
        rastakhansRubmle?.let { allCards.addAll(it) }
        riseOfShadows?.let { allCards.addAll(it) }
        tavernsOfTime?.let { allCards.addAll(it) }
        saviorsOfUldum?.let { allCards.addAll(it) }
        descentOfDragons?.let { allCards.addAll(it) }
        galakrondsAwakeing?.let { allCards.addAll(it) }
        wildEvent?.let { allCards.addAll(it) }
        scholmanceAcademy?.let { allCards.addAll(it) }
        battlegrounds?.let { allCards.addAll(it) }
        demonHunterInitiate?.let { allCards.addAll(it) }
        madnessAtTheDarkmoonFaire?.let { allCards.addAll(it) }
        forgedinBarrens?.let { allCards.addAll(it) }
        legacy?.let { allCards.addAll(it) }
        core?.let { allCards.addAll(it) }
        vanilla?.let { allCards.addAll(it) }
        wailingCaverns?.let { allCards.addAll(it) }
        unitedInStormwind?.let { allCards.addAll(it) }
        mercenaries?.let { allCards.addAll(it) }
        fracturedInAlteacValley?.let { allCards.addAll(it) }
        voyageToTheSunkenCity?.let { allCards.addAll(it) }
        unknown?.let { allCards.addAll(it) }
        murderAtCastleNathria?.let { allCards.addAll(it) }
        marchOfTheLichKing?.let { allCards.addAll(it) }
        pathOfArthas?.let { allCards.addAll(it) }

        return allCards
    }
}

internal data class CardResponse(
    @SerializedName("img") val image: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("flavor") val flavor: String? = "",
    @SerializedName("text") val description: String? = "",
    @SerializedName("cardSet") val cardSet: String? = "",
    @SerializedName("type") val type: String? = "",
    @SerializedName("rarity") val rarity: String? = "",
    @SerializedName("faction") val faction: String? = "",
    @SerializedName("cost") val cost: Int = 0,
    @SerializedName("attack") val attack: Int = 0,
    @SerializedName("health") val health: Int = 0
) : java.io.Serializable

internal fun CardResponse.toDomainModel(): Card {
    return Card(
        image = this.image,
        name = this.name,
        flavor = this.flavor,
        description = this.description,
        cardSet = this.cardSet,
        type = this.type,
        rarity = this.rarity,
        faction = this.faction,
        cost = this.cost,
        attack = this.attack,
        health = this.health
    )
}
