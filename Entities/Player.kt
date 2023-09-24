package Entities

import Models.GameCharacter

class Player(baseDamage: Int, armor: Int, lifePoints: Int, damageRange: IntRange) :
    GameCharacter(baseDamage, armor, lifePoints, damageRange) {

    private var healCount = 0
    private var maxHeal = (lifePoints * 0.3).toInt()
    private var newLifePoints = lifePoints
    fun restoreHealth() {
        if (healCount < 4) {
            lifePoints += maxHeal
            if (lifePoints > newLifePoints)
                lifePoints = newLifePoints
            healCount++
        }
    }

    fun canHeal(): Boolean {
        return healCount < 4
    }
}
