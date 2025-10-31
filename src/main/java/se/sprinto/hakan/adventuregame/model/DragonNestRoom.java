package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class DragonNestRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du öppnar en dörr och hittar dig själv i ett draknäste. En drake står framför dig med en hotfull blick!");
        Enemy dragon = new Enemy("Dragon", 50, 0, 15);

        while (player.isAlive() && dragon.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(dragon);
                ui.showMessage("Du attackerar draken! Drakens HP: " + dragon.getHealth());
                if (dragon.isAlive()) {
                    dragon.attack(player);
                    ui.showMessage("Draken attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade draken!");
                    player.setDefeatedDragon(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}
