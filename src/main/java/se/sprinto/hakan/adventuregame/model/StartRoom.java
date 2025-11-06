package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class StartRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du befinner dig i start-rummet. Du ser tre dörrar framför dig.");
        boolean exit = false;
        while (!exit) {
            String choice = ui.getInput("Vilken dörr vill du ta? (1=Skog, 2=Fängelse, 3=Skattkammare, 4=Slott, 5=Boss, 6=Dörr q=avsluta)");
            switch (choice) {
                case "1":
                    if (!player.hasFoundKey()) {
                        new ForestRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och plockat upp nyckeln.");
                    }
                    break;
                case "2":
                    new DungeonRoom().enterRoom(player, ui);
                    break;
                case "3":
                    if (!player.hasOpenedChest()) {
                        new TreasureRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och öppnat kistan");
                    }
                    break;
                case "4":
                    // Slottet
                    if (player.hasFoundSerum() && player.hasThrowSerum()) {
                        ui.showMessage("Rummet är tomt, försöker du få tillbaka serumet? Skulle inte ha kastas den eller hur?");
                    } else if (player.hasFoundSerum()) {
                        ui.showMessage("Rummet är tomt");
                    } else {
                        new ElfCastleRoom().enterRoom(player, ui);
                    }
                    break;
                case "5":
                    // Boss
                    new BossRoom().enterRoom(player, ui);
                    break;
                case "6":
                    // Dragon
                    new DragonNestRoom().enterRoom(player, ui);
                    break;
                case "q":
                    exit = true;
                    break;
                default:
                    ui.showMessage("Ogiltigt val.");
            }
            if (player.hasWon()) {
                ui.showMessage("Grattis! Du har klarat spelet!");
                exit = true;
            } else if (player.getHealth() <= 0) {
                ui.showMessage(("Din hälsa är kritisk, du vacklar till och dör!"));
                exit = true;
            }
        }
    }
}

