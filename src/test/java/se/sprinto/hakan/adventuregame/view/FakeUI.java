package se.sprinto.hakan.adventuregame.view;

import se.sprinto.hakan.adventuregame.model.Player;

public class FakeUI implements UI {
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public void showMessage(String message) {}
    @Override
    public String getInput(String prompt) {
        System.out.println("Enter Your Input:");
        return input;
    }
}
