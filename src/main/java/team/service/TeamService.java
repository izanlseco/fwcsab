package team.service;

import team.model.Match;
import team.model.Team;

import java.util.ArrayList;
import java.util.logging.Logger;

public class TeamService implements ITeamService {
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    final ArrayList<Match> arrayOfMatches = new ArrayList<>();

    final ICreateService createService = new CreateService();
    final ISummaryService summaryService = new SummaryService();

    public boolean create(Team homeTeam, Team awayTeam) {
        try {
            return this.arrayOfMatches.add(this.createService.create(homeTeam, awayTeam));
        } catch (IllegalArgumentException e) {
            log.severe("Team names cannot be null or empty, homeTeam is " + homeTeam.getName()
                    + " awayTeam is " + awayTeam.getName());
        }
        return false;
    }

    public ArrayList<Match> summary() {
        return this.summaryService.summary(this.arrayOfMatches);
    }
}
