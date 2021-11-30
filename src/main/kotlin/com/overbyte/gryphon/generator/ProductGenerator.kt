package com.overbyte.gryphon.generator

import com.overbyte.gryphon.entity.Game
import com.overbyte.gryphon.entity.Product
import java.math.BigDecimal
import kotlin.random.Random

object ProductGenerator {
    private val random = Random(System.currentTimeMillis())

    fun next() = products[random.nextInt(products.count())]

    val products = listOf(
        Game().apply {
            name = "Horrified"; baseCost = BigDecimal(22.49)
            publisher = "Ravensburger"
            minAge = 10; minPayers = 1; maxPlayers = 5; minPlayTime = 60 },
        Game().apply {
            name = "Valeria: Card Kingdoms"; baseCost = BigDecimal(50.00)
            publisher = "Daily Magic Games"
            minAge = 10; minPayers = 1; maxPlayers = 5; minPlayTime = 45; maxPlayTime = 60 },
        Game().apply { name = "Betrayal at House on the Hill"; baseCost = BigDecimal(28.34)
            publisher = "Avalon Hill"
            minAge = 10; minPayers = 3; maxPlayers = 6; minPlayTime = 60; maxPlayTime = 90 },
        Game().apply { name = "Paranormal Detectives"; baseCost = BigDecimal(49.99)
            publisher = "Lucky Duck Games"
            minAge = 10; minPayers = 2; maxPlayers = 6; minPlayTime = 30; maxPlayTime = 50 },
        Game().apply { name = "The Quest for El Dorado"; baseCost = BigDecimal(38.06)
            publisher = "Ravensburger"
            minAge = 10; minPayers = 2; maxPlayers = 4; minPlayTime = 60 },
        Game().apply { name = "The Bloody Inn"; baseCost = BigDecimal(29.99)
            publisher = "Pearl Games"
            minAge = 14; minPayers = 2; maxPlayers = 4; minPlayTime = 45 },
        Game().apply { name = "Werewords"; baseCost = BigDecimal(26.37)
            publisher = "Bezier Games"
            minAge = 8; minPayers = 4; maxPlayers = 10; minPlayTime = 15 },
        Game().apply { name = "Port Royal"; baseCost = BigDecimal(21.98)
            publisher = "Pegasus Spiele"
            minAge = 8; minPayers = 2; maxPlayers = 5; minPlayTime = 20; maxPlayTime = 50 },
        Game().apply { name = "Point Salad"; baseCost = BigDecimal(16.99)
            publisher = "Alderac Entertainment Group"
            minAge = 8; minPayers = 2; maxPlayers = 6; minPlayTime = 15; maxPlayTime = 30 },
        Game().apply { name = "Antiquity Quest"; baseCost = BigDecimal(26.99)
            publisher = "Grandpa Beck's Games"
            minAge = 10; minPayers = 2; maxPlayers = 8; minPlayTime = 30; maxPlayTime = 90 },
        Game().apply { name = "Bohnanza"; baseCost = BigDecimal(38.00)
            publisher = "AMIGO"
            minAge = 13; minPayers = 2; maxPlayers = 7; minPlayTime = 45 },
        Game().apply { name = "Reef"; baseCost = BigDecimal(39.99)
            publisher = "Next Move Games"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 30; maxPlayTime = 45 },
        Game().apply { name = "Lost Cities"; baseCost = BigDecimal(38.24)
            publisher = "Rio Grande Games"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 30; maxPlayTime = 60 },
        Game().apply { name = "The 7th Continent"; baseCost = BigDecimal(69.0)
            publisher = "Serious Poulp"
            minAge = 14; minPayers = 1; maxPlayers = 4; minPlayTime = 5; maxPlayTime = 1000 },
        Game().apply { name = "Tiny Epic Galaxies"; baseCost = BigDecimal(39.99)
            publisher = "Gamelyn Games"
            minAge = 14; minPayers = 1; maxPlayers = 5; minPlayTime = 30; maxPlayTime = 45 },
        Game().apply { name = "The Crew - Quest For Planet Nine"; baseCost = BigDecimal(10.19)
            publisher = "KOSMOS"
            minAge = 10; minPayers = 2; maxPlayers = 5; minPlayTime = 20 },
        Game().apply { name = "Dragon's Hoard"; baseCost = BigDecimal(15.99)
            publisher = "Mortensen Games"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 25; maxPlayTime = 45 },
        Game().apply { name = "Arboretum"; baseCost = BigDecimal(16.45)
            publisher = "Z-Man Games"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 30 },
        Game().apply { name = "High Society"; baseCost = BigDecimal(15.10)
            publisher = "Ravensburger"
            minAge = 10; minPayers = 3; maxPlayers = 5; minPlayTime = 15; maxPlayTime = 30 },
        Game().apply { name = "One Night Ultimate Werewolf"; baseCost = BigDecimal(24.99)
            publisher = "Bezier Games"
            minAge = 8; minPayers = 3; maxPlayers = 10; minPlayTime = 10 },
        Game().apply { name = "Karuba The Card Game"; baseCost = BigDecimal(21.99)
            publisher = "HABA"
            minAge = 8; minPayers = 2; maxPlayers = 6; minPlayTime = 10; maxPlayTime = 15 },
        Game().apply { name = "Taboo"; baseCost = BigDecimal(12.97)
            publisher = "Hasbro"
            minAge = 12; minPayers = 4; maxPlayers = 10; minPlayTime = 20 },
        Game().apply { name = "Tsuro of the Seas"; baseCost = BigDecimal(39.95)
            publisher = "Calliope Games"
            minAge = 8; minPayers = 2; maxPlayers = 8; minPlayTime = 20; maxPlayTime = 40 },
        Game().apply { name = "Res Arcana"; baseCost = BigDecimal(35.99)
            publisher = "Sand Castle Games"
            minAge = 14; minPayers = 2; maxPlayers = 4; minPlayTime = 60 },
        Game().apply { name = "7 Wonders"; baseCost = BigDecimal(43.10)
            publisher = "Repos Production"
            minAge = 10; minPayers = 3; maxPlayers = 7; minPlayTime = 30 },
        Game().apply { name = "Legends of Andor"; baseCost = BigDecimal(42.99)
            publisher = "KOSMOS"
            minAge = 10; minPayers = 2; maxPlayers = 4; minPlayTime = 60; maxPlayTime = 90 },
        Game().apply { name = "Jumbo Sequence"; baseCost = BigDecimal(54.99)
            publisher = "University Games"
            minAge = 10; minPayers = 2; maxPlayers = 12; minPlayTime = 30; maxPlayTime = 60 },
        Game().apply { name = "Azul"; baseCost = BigDecimal(31.99)
            publisher = "Plan B Games"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 30; maxPlayTime = 45 },
        Game().apply { name = "Sagrada"; baseCost = BigDecimal(36.95)
            publisher = "Floodgate Games"
            minAge = 10; minPayers = 1; maxPlayers = 4; minPlayTime = 20; maxPlayTime = 40 },
        Game().apply { name = "Call to Adventure"; baseCost = BigDecimal(39.95)
            publisher = "Brotherwise Games"
            minAge = 13; minPayers = 1; maxPlayers = 4; minPlayTime = 30; maxPlayTime = 60 },
        Game().apply { name = "Splendor"; baseCost = BigDecimal(28.99)
            publisher = "Space Cowboys"
            minAge = 10; minPayers = 2; maxPlayers = 4; minPlayTime = 30 },
        Game().apply { name = "Cryptid"; baseCost = BigDecimal(32.0)
            publisher = "Osprey Games"
            minAge = 14; minPayers = 2; maxPlayers = 4; minPlayTime = 30; maxPlayTime = 45 },
        Game().apply { name = "Not Alone"; baseCost = BigDecimal(21.49)
            publisher = "Stronghold Games"
            minAge = 10; minPayers = 2; maxPlayers = 7; minPlayTime = 30; maxPlayTime = 60 },
        Game().apply { name = "Kingdomino"; baseCost = BigDecimal(19.82)
            publisher = "Blue Orange"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 15 },
        Game().apply { name = "Take 5"; baseCost = BigDecimal(14.99)
            publisher = "AMIGO"
            minAge = 8; minPayers = 2; maxPlayers = 10; minPlayTime = 60 },
        Game().apply { name = "Linko"; baseCost = BigDecimal(10.79)
            publisher = "Ravensburger"
            minAge = 10; minPayers = 1; maxPlayers = 5; minPlayTime = 15 },
        Game().apply { name = "Cockroach Poker"; baseCost = BigDecimal(16.99)
            publisher = "Schmidt"
            minAge = 8; minPayers = 2; maxPlayers = 6; minPlayTime = 15; maxPlayTime = 25 },
        Game().apply { name = "No Thanks!"; baseCost = BigDecimal(12.66)
            publisher = "AMIGO"
            minAge = 8; minPayers = 3; maxPlayers = 7; minPlayTime = 15 },
        Game().apply { name = "Coloretto"; baseCost = BigDecimal(15.53)
            publisher = "Rio Grande Games"
            minAge = 10; minPayers = 2; maxPlayers = 5; minPlayTime = 20 },
        Game().apply { name = "Skull King"; baseCost = BigDecimal(16.99)
            publisher = "Grandpa Beck's Games"
            minAge = 8; minPayers = 2; maxPlayers = 8; minPlayTime = 30; maxPlayTime = 45 },
        Game().apply { name = "10 Minute Heist"; baseCost = BigDecimal(19.99)
            publisher = "Daily Magic Games"
            minAge = 14; minPayers = 2; maxPlayers = 5; minPlayTime = 10 },
        Game().apply { name = "Silver and Gold"; baseCost = BigDecimal(13.89)
            publisher = "Pandasaurus Games"
            minAge = 8; minPayers = 2; maxPlayers = 4; minPlayTime = 20 },
    )

}