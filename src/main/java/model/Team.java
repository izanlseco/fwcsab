package model;

public record Team(String name, int score) {

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
