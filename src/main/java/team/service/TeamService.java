package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;
import team.model.Team;

import java.util.*;

@Slf4j
public class TeamService implements ITeamService {

    final ArrayList<Match> matchSummary = new ArrayList<>();

    public boolean create(Team homeTeam, Team awayTeam) {
        if (homeTeam.getName() == null || awayTeam.getName() == null) {
            log.error("Team names cannot be null, homeTeam is {}, awayTeam is {}",
                    homeTeam.getName(), awayTeam.getName());
            throw new IllegalArgumentException("Team names cannot be null");
        }
        if (homeTeam.getName().equals("") || awayTeam.getName().equals("")) {
            log.error("Team names cannot be empty, homeTeam is {}, awayTeam is {}",
                    homeTeam.getName(), awayTeam.getName());
            throw new IllegalArgumentException("Team names cannot be empty");
        }
        final Match teamMatch = new Match(homeTeam, awayTeam);

        log.info("Creating match with {} as home team and {} as away team",
                teamMatch.getHomeTeam().getName(),
                teamMatch.getAwayTeam().getName());

        return this.matchSummary.add(teamMatch);
    }

    public ArrayList<Match> summary() {
        if (this.matchSummary.isEmpty()) {
            log.info("Team summary {} is empty", this.matchSummary);
            return this.matchSummary;
        }

        orderMatch(this.matchSummary);

        log.info("Ordered summary {}", this.matchSummary);

        return this.matchSummary;
    }

    private void orderMatch(final ArrayList<Match> matchSummary) {
        Collections.reverse(matchSummary);
        matchSummary.sort(Comparator
                        .comparingInt((Match match) ->
                                match.getHomeTeam().getScore() + match.getAwayTeam().getScore()
                        ).reversed()
                );
    }
}
