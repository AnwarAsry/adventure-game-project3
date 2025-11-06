package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class ElfCastleRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du hittar ett röd serum!");

        String choice = ui.getInput("Vill du dricka serumet? (ja/nej)");

        if (choice.equalsIgnoreCase("ja")) {
            player.drinkSerum();
            ui.showMessage("Din hälsa ökade med 50! Ditt HP: " + player.getHealth());
        } else {
            ui.showMessage("Du kastade serumet :(");
            player.addScore(20);
            player.setThrowSerum(true);
        }

        player.setFoundSerum(true);
    }
}
