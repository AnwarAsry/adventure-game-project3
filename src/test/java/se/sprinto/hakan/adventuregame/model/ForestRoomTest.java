package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class ForestRoomTest {
    @Test
    public void testEnterRoom() {
        ForestRoom forestRoom = new ForestRoom();
        Player player = new Player.Builder()
                .name("Awar")
                .health(100)
                .score(0)
                .strength(10)
                .foundKey(false)
                .defeatedGoblin(false)
                .openedChest(false).build();
        FakeUI fakeUI = new FakeUI();

        fakeUI.setInput("ja");
        forestRoom.enterRoom(player, fakeUI);

        Assertions.assertTrue(player.hasFoundKey());
    }
}
