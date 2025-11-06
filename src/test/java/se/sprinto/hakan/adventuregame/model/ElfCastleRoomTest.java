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
public class ElfCastleRoomTest {

    private ElfCastleRoom room;
    private Player player;

    @Mock
    private UI ui;

    @BeforeEach
    public void setUp() {
        room = new ElfCastleRoom();
        player = new Player.Builder()
                .name("Awar")
                .health(10)
                .score(0)
                .strength(10)
                .foundSerum(false)
                .throwSerum(false)
                .openedChest(false).build();
    }

    @Test
    public void testPlayerDrinksSerum() {
        // player chooses yes
        when(ui.getInput(anyString())).thenReturn("ja");

        room.enterRoom(player, ui);

        verify(ui).showMessage("Din hälsa ökade med 50! Ditt HP: " + player.getHealth());
        assertTrue(player.hasFoundSerum());
        assertFalse(player.hasThrowSerum());
        // start HP is 10 plus 50 is 60
        assertEquals(60, player.getHealth());
    }

    @Test
    public void testPlayerThrowsSerum() {
        // player chooses no
        when(ui.getInput(anyString())).thenReturn("nej");

        room.enterRoom(player, ui);

        verify(ui).showMessage("Du kastade serumet :(");
        assertTrue(player.hasFoundSerum());
        assertTrue(player.hasThrowSerum());
        // start HP is 10
        assertEquals(10, player.getHealth());
    }
}
