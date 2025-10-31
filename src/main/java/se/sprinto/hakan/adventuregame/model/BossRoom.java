package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class BossRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du träffar en Skeleton King. Han verkar vara arg!");
        Enemy skeletonKing = new Enemy("Skeleton King", 35, 0, 10);

        while (player.isAlive() && skeletonKing.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(skeletonKing);
                ui.showMessage("Du attackerar Skeleton King! Skeleton King HP: " + skeletonKing.getHealth());
                if (skeletonKing.isAlive()) {
                    skeletonKing.attack(player);
                    ui.showMessage("Skeleton King attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade Skeleton King!");
                    player.setDefeatedSkeletonKing(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}


