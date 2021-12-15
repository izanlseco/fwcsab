package util;

import model.Team;

public class ValidateTeam {
    public void validateTeam(Team homeTeam, Team awayTeam) {
        validateName(homeTeam, awayTeam);
        validateScore(homeTeam, awayTeam);

    }
    private void validateName(Team homeTeam, Team awayTeam) {
        if ((homeTeam.getName() == null || awayTeam.getName() == null) || homeTeam.getName().equals("") || awayTeam.getName().equals("")) {
            throw new IllegalArgumentException("Team names cannot be null or empty");
        }
    }

    private void validateScore(Team homeTeam, Team awayTeam) {
        if (homeTeam.getScore() < 0 || awayTeam.getScore() < 0) {
            throw new IllegalArgumentException("Team scores cannot be negative");
        }
    }
}
