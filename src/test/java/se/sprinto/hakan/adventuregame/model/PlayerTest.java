package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testAttack() {
        Player player = new Player.Builder()
                .name("Awar")
                .health(100)
                .score(0)
                .strength(10)
                .foundKey(false)
                .defeatedEnemy(false)
                .openedChest(false).build();
        Enemy enemy = new Enemy("Goblin", 20, 0, 1);

        player.attack(enemy);

        Assertions.assertEquals(10, enemy.getHealth());
    }
}
