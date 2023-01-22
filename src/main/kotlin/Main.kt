import ai.gameLoop

@Suppress("unused")
private object Traveler {
    init {
        js("var Traveler = require('Traveler');")
    }
}

/**
 * Entry point
 * is called by screeps
 *
 * must not be removed by DCE
 */
@Suppress("unused")
fun loop() {
    Traveler
    gameLoop()
}
