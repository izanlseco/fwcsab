package team.util;

import team.model.Team;

public class ValidateTeam {
    public void validateTeam(Team homeTeam, Team awayTeam) {
        if ((homeTeam.getName() == null || awayTeam.getName() == null) || homeTeam.getName().equals("") || awayTeam.getName().equals("")) {
            throw new IllegalArgumentException("Team names cannot be null or empty");
        }
    }
}
