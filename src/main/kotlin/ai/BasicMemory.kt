package ai

import screeps.api.*
import screeps.utils.memory.memory

/* Add the variables that you want to store to the persistent memory for each object type.
* They can be accessed by using the .memory attribute of any of the instances of that class
* i.e. creep.memory.building = true */

enum class Role {
    UNASSIGNED,
    HARVESTER,
    BUILDER,
    UPGRADER,
    HAULER
}

/* Creep.memory */
var CreepMemory.role by memory(Role.UNASSIGNED)
var CreepMemory.target : String by memory { "" }


/* Rest of the persistent memory structures.
* These set an unused test variable to 0. This is done to illustrate the how to add variables to
* the memory. Change or remove it at your convenience.*/

/* room.memory */
var RoomMemory.numberOfCreeps : Int by memory { 0 }

