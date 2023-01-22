package ai

import traveler.travelTo
import screeps.api.*
import screeps.api.structures.StructureController


fun Creep.upgrade(controller: StructureController) {

    if (store[RESOURCE_ENERGY] == 0) {
        val sources = room.find(FIND_SOURCES)
        if (harvest(sources[0]) == ERR_NOT_IN_RANGE) {
            travelTo(sources[0].pos)
        }
    } else {
        if (upgradeController(controller) == ERR_NOT_IN_RANGE) {
            travelTo(controller.pos)
        }
    }
}

fun Creep.harvest(fromRoom: Room = this.room, toRoom: Room = this.room) {
    if (store[RESOURCE_ENERGY] < store.getCapacity()) {
        val sources = fromRoom.find(FIND_SOURCES)
        if (harvest(sources[0]) == ERR_NOT_IN_RANGE) {
            travelTo(sources[0].pos)
        }
    } else {
        val targets = toRoom.find(FIND_MY_STRUCTURES)
            .filter { (it.structureType == STRUCTURE_EXTENSION || it.structureType == STRUCTURE_SPAWN) }
            .map { it.unsafeCast<StoreOwner>() }
            .filter { it.store[RESOURCE_ENERGY] < it.store.getCapacity() }

        if (targets.isNotEmpty()) {
            if (transfer(targets[0], RESOURCE_ENERGY) == ERR_NOT_IN_RANGE) {
                travelTo(targets[0].pos)
            }
        }
    }
}
