package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;
import team.model.Team;

@Slf4j
public class CreateService implements ICreateService {
    public Match create(Team homeTeam, Team awayTeam) {
        final Match teamMatch = new Match(homeTeam, awayTeam);

        log.info("Creating match with {} as home team and {} as away team",
                teamMatch.getHomeTeam().getName(),
                teamMatch.getAwayTeam().getName());

        return teamMatch;
    }
}
