package Models

import kotlin.random.Random

abstract class GameCharacter(private var baseDamage: Int, private var armor: Int, var lifePoints: Int, private var damageRange: IntRange) {
    init {
        require(baseDamage in 1..30) { "Урон должен быть от 1 до 30." }
        require(armor in 1..30) { "Защита должна быть от 1 до 30." }
        require(lifePoints > 0) { "Здоровье должно быть больше 0." }
    }

    fun attack(enemy: GameCharacter) {
        val damage = baseDamage - enemy.armor + 1
        val diceRolls = IntArray(damage.coerceAtLeast(1)) { Random.nextInt(1, 7) }
        if (diceRolls.any { it >= 5 }) {
            val baseDamage = Random.nextInt(damageRange.first, damageRange.last + 1)
            enemy.lifePoints -= baseDamage
            if (enemy.lifePoints <= 0) {
                enemy.lifePoints = 0
            }
        }
    }
}

