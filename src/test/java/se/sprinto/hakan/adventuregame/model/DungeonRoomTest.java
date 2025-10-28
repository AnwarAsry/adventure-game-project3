package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class DungeonRoomTest {
    @Test
    public void testEnterRoom() {
        DungeonRoom dungeonRoom = new DungeonRoom();
        Player player = new Player.Builder().name("Awar").health(100).score(0).strength(10).build();
        FakeUI fakeUI = new FakeUI();

        fakeUI.setInput("a");
        dungeonRoom.enterRoom(player, fakeUI);

        Assertions.assertTrue(player.hasDefeatedEnemy());
    }
}
