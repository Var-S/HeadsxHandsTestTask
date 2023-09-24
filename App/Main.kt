import Entities.Monster
import Entities.Player
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    println("Введите броню игрока:")
    val playerArmor = scanner.nextInt()

    println("Введите атаку игрока:")
    val playerDamage = scanner.nextInt()

    println("Введите здоровье игрока:")
    val playerLifePoints = scanner.nextInt()

    println("Введите броню монстра:")
    val monsterArmor = scanner.nextInt()

    println("Введите атаку монстра:")
    val monsterDamage = scanner.nextInt()

    println("Введите здоровье монстра:")
    val monsterLifePoints = scanner.nextInt()

    val player = Player(playerDamage, playerArmor, playerLifePoints, 1..6)
    val monster = Monster(monsterDamage, monsterArmor, monsterLifePoints, 1..6)

    while (player.lifePoints > 0 && monster.lifePoints > 0) {
        println("Выбери действие: 1 - атаковать, 2 - вылечиться")
        when (scanner.nextInt()) {
            1 -> player.attack(monster)
            2 -> if (player.canHeal()) player.restoreHealth()
        }

        println("Здоровье монстра: ${monster.lifePoints}")

        if (monster.lifePoints <= 0) {
            println("Вы победили!")
            break
        }

        monster.attack(player)
        println("Здоровье игрока: ${player.lifePoints}")

        if (player.lifePoints <= 0) {
            println("Монстр победил!")
            break
        }

        if (player.canHeal()) {
            println("У вас есть возможность вылечиться!")
        }
    }
}
