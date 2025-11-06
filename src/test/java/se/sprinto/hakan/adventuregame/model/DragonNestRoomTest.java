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
public class DragonNestRoomTest {

    private DragonNestRoom room;
    private Player player;

    @Mock
    private UI ui;

    @BeforeEach
    public void setUp() {
        room = new DragonNestRoom();
        player = new Player.Builder()
                .name("Awar")
                .health(100)
                .score(0)
                .strength(10)
                .defeatedDragon(false)
                .openedChest(false).build();
    }

    @Test
    public void testPlayerDefeatsDragon() {
        // attack multiple times
        when(ui.getInput(anyString())).thenReturn("a");

        room.enterRoom(player, ui);

        assertTrue(player.hasDefeatedDragon());
        verify(ui).showMessage("Du besegrade draken!");
    }

    @Test
    public void testPlayerRetreats() {
        when(ui.getInput(anyString())).thenReturn("r");

        room.enterRoom(player, ui);

        assertFalse(player.hasDefeatedDragon());
        verify(ui).showMessage("Du springer därifrån!");
    }
}
