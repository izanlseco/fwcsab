package model;

public record Match(Team homeTeam, Team awayTeam) {

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }
}
