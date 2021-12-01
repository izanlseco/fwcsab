package team.service;

import team.model.Match;
import team.model.Team;
import team.util.ValidateTeam;

import java.util.logging.Logger;

public class CreateService implements ICreateService {
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    final ValidateTeam validateTeam = new ValidateTeam();

    public Match create(Team homeTeam, Team awayTeam) {

        this.validateTeam.validateTeam(homeTeam, awayTeam);

        final Match teamMatch = new Match(homeTeam, awayTeam);

        log.info("Creating match with " + teamMatch.getHomeTeam().getName()
                + " as home team and " + teamMatch.getAwayTeam().getName() + " as away team");
        return teamMatch;
    }
}
