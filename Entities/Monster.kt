package Entities

import Models.GameCharacter

class Monster(baseDamage: Int, armor: Int, lifePoints: Int, damageRange: IntRange) :
    GameCharacter(baseDamage, armor, lifePoints, damageRange)