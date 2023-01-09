package com.gabrielgrs2.feature.cardlist.data.datasource

import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.AllCardsResponse
import com.gabrielgrs2.feature.cardlist.data.datasource.api.response.CardResponse

object DataFixtures {

    internal fun getCardsApiModel() = listOf(
        getCardApiModel(),
        getCardApiModel()
    )

    private fun getCardApiModel(
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
    ): CardResponse =
        CardResponse(
            image,
            name,
            flavor,
            description,
            cardSet,
            type,
            rarity,
            faction,
            cost,
            attack,
            health
        )


    object ApiResponse {
        internal fun getAllCardsResponse() = AllCardsResponse(
            basic = getCardsApiModel(),
            classic = getCardsApiModel(),
            hallOfFame = getCardsApiModel(),
            missions = getCardsApiModel(),
            naxxramas = getCardsApiModel(),
            goblinVsGnomes = getCardsApiModel(),
            blackrockMountain = getCardsApiModel(),
            theGrandTournament = getCardsApiModel(),
            credits = getCardsApiModel(),
            heroSkins = getCardsApiModel(),
            tavernBrawl = getCardsApiModel(),
            theLeagueOfExplorer = getCardsApiModel(),
            whispersOfTheOldGoods = getCardsApiModel(),
            oneNightInKarazhan = getCardsApiModel(),
            meanStreetsOfGadgetzan = getCardsApiModel(),
            journeToUnGoro = getCardsApiModel(),
            knightsOfTheFrozenThrone = getCardsApiModel(),
            koboldsAndCatacombs = getCardsApiModel(),
            theWitchwood = getCardsApiModel(),
            theBoomsdayProject = getCardsApiModel(),
            rastakhansRubmle = getCardsApiModel(),
            riseOfShadows = getCardsApiModel(),
            tavernsOfTime = getCardsApiModel(),
            saviorsOfUldum = getCardsApiModel(),
            descentOfDragons = getCardsApiModel(),
            galakrondsAwakeing = getCardsApiModel(),
            ashesOfOutland = getCardsApiModel(),
            wildEvent = getCardsApiModel(),
            scholmanceAcademy = getCardsApiModel(),
            battlegrounds = getCardsApiModel(),
            demonHunterInitiate = getCardsApiModel(),
            madnessAtTheDarkmoonFaire = getCardsApiModel(),
            forgedinBarrens = getCardsApiModel(),
            legacy = getCardsApiModel(),
            core = getCardsApiModel(),
            vanilla = getCardsApiModel(),
            wailingCaverns = getCardsApiModel(),
            unitedInStormwind = getCardsApiModel(),
            mercenaries = getCardsApiModel(),
            fracturedInAlteacValley = getCardsApiModel(),
            voyageToTheSunkenCity = getCardsApiModel(),
            unknown = getCardsApiModel(),
            murderAtCastleNathria = getCardsApiModel(),
            marchOfTheLichKing = getCardsApiModel(),
            pathOfArthas = getCardsApiModel()
        )
    }
}
