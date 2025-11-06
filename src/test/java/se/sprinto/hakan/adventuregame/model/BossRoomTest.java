package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.view.UI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BossRoomTest {

    private BossRoom room;
    private Player player;

    @Mock
    private UI ui;

    @BeforeEach
    public void setUp() {
        room = new BossRoom();
        player = new Player.Builder()
                .name("Awar")
                .health(100)
                .score(0)
                .strength(10)
                .defeatedSkeletonKing(false)
                .openedChest(false).build();
    }

    @Test
    public void testPlayerDefeatsSkeletonKing() {
        // attack multiple times
        when(ui.getInput(anyString())).thenReturn("a");

        room.enterRoom(player, ui);

        assertTrue(player.hasDefeatedSkeletonKing());
        verify(ui).showMessage("Du besegrade Skeleton King!");
    }

    @Test
    public void testPlayerRetreats() {
        when(ui.getInput(anyString())).thenReturn("r");

        room.enterRoom(player, ui);

        verify(ui).showMessage("Du springer därifrån!");
        assertFalse(player.hasDefeatedSkeletonKing());
    }
}
