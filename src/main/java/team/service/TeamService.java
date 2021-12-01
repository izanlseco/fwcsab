package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;
import team.model.Team;

import java.util.ArrayList;

@Slf4j
public class TeamService implements ITeamService {

    final ArrayList<Match> arrayOfMatches = new ArrayList<>();

    final ICreateService createService = new CreateService();
    final ISummaryService summaryService = new SummaryService();

    public boolean create(Team homeTeam, Team awayTeam) {
        try {
            return this.arrayOfMatches.add(this.createService.create(homeTeam, awayTeam));
        } catch (IllegalArgumentException e) {
            log.error("Team names cannot be null or empty, homeTeam is {}, awayTeam is {}",
                    homeTeam.getName(), awayTeam.getName());
        }
        return false;
    }

    public ArrayList<Match> summary() {
        return this.summaryService.summary(this.arrayOfMatches);
    }
}
