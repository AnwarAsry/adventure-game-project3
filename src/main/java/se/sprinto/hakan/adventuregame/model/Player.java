package se.sprinto.hakan.adventuregame.model;

public class Player extends AbstractCharacter {
    private boolean foundKey;
    private boolean foundSerum;
    private boolean throwSerum;
    private boolean defeatedGoblin;
    private boolean defeatedDragon;
    private boolean defeatedSkeletonKing;
    private boolean openedChest;

    private Player(Builder builder) {
        super(builder.name, builder.health, builder.score, builder.strength);
        this.foundKey = builder.foundKey;
        this.foundSerum = builder.foundSerum;
        this.throwSerum = builder.throwSerum;
        this.defeatedGoblin = builder.defeatedGoblin;
        this.defeatedDragon = builder.defeatedDragon;
        this.defeatedSkeletonKing = builder.defeatedSkeletonKing;
        this.openedChest = builder.openedChest;
    }

    public static class Builder {
        private String name;
        private int health;
        private int score;
        private int strength;
        private boolean foundKey;
        private boolean foundSerum;
        private boolean throwSerum;
        private boolean defeatedGoblin;
        private boolean defeatedDragon;
        private boolean defeatedSkeletonKing;
        private boolean openedChest;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder health(int health) {
            this.health = health;
            return this;
        }
        public Builder score(int score) {
            this.score = score;
            return this;
        }
        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }
        public Builder foundKey(boolean foundKey) {
            this.foundKey = foundKey;
            return this;
        }
        public Builder foundSerum(boolean foundSerum) {
            this.foundSerum = foundSerum;
            return this;
        }
        public Builder throwSerum(boolean throwSerum) {
            this.throwSerum = throwSerum;
            return this;
        }
        public Builder defeatedGoblin(boolean defeatedGoblin) {
            this.defeatedGoblin = defeatedGoblin;
            return this;
        }
        public Builder defeatedDragon(boolean defeatedDragon) {
            this.defeatedDragon = defeatedDragon;
            return this;
        }
        public Builder defeatedSkeletonKing(boolean defeatedSkeletonKing) {
            this.defeatedSkeletonKing = defeatedSkeletonKing;
            return this;
        }
        public Builder openedChest(boolean openedChest) {
            this.openedChest = openedChest;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }

    public boolean hasFoundKey() {
        return foundKey;
    }
    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
    }

    public boolean hasFoundSerum() {
        return foundSerum;
    }
    public void setFoundSerum(boolean foundSerum) {
        this.foundSerum = foundSerum;
    }

    public boolean hasThrowSerum() {
        return throwSerum;
    }
    public void setThrowSerum(boolean throwSerum) {
        this.throwSerum = throwSerum;
    }

    public boolean hasDefeatedGoblin() {
        return defeatedGoblin;
    }
    public void setDefeatedGoblin(boolean defeatedGoblin) {
        this.defeatedGoblin = defeatedGoblin;
    }

    public boolean hasDefeatedDragon() {
        return defeatedDragon;
    }
    public void setDefeatedDragon(boolean defeatedDragon) {
        this.defeatedDragon = defeatedDragon;
    }

    public boolean hasDefeatedSkeletonKing() {
        return defeatedSkeletonKing;
    }
    public void setDefeatedSkeletonKing(boolean defeatedSkeletonKing) {
        this.defeatedSkeletonKing = defeatedSkeletonKing;
    }

    public boolean hasOpenedChest() {
        return openedChest;
    }
    public void setOpenedChest(boolean openedChest) {
        this.openedChest = openedChest;
    }

    public boolean hasWon() {
        return foundKey && defeatedGoblin && defeatedDragon && defeatedSkeletonKing && openedChest;
    }

    public void drinkSerum() {
        this.setHealth(this.getHealth() + 50);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (!target.isAlive()) {
            addScore(50);
        }
    }
}
