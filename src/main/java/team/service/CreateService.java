package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;
import team.model.Team;
import team.util.ValidateTeam;

@Slf4j
public class CreateService implements ICreateService {

    final ValidateTeam validateTeam = new ValidateTeam();

    public Match create(Team homeTeam, Team awayTeam) {

        this.validateTeam.validateTeam(homeTeam, awayTeam);

        final Match teamMatch = new Match(homeTeam, awayTeam);

            log.info("Creating match with {} as home team and {} as away team",
                    teamMatch.getHomeTeam().getName(),
                    teamMatch.getAwayTeam().getName());
        return teamMatch;
    }
}
