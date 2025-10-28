package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class TreasureRoomTest {
    @Test
    public void testEnterRoom() {
        TreasureRoom treasureRoom = new TreasureRoom();
        ForestRoom forestRoom = new ForestRoom();

        Player player = new Player.Builder().name("Awar").health(100).score(0).strength(10).build();
        FakeUI fakeUI = new FakeUI();

        fakeUI.setInput("ja");
        forestRoom.enterRoom(player, fakeUI);
        treasureRoom.enterRoom(player, fakeUI);

        Assertions.assertTrue(player.hasOpenedChest());
    }
}
