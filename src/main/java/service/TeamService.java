package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;
import team.model.Team;
import team.util.ValidateTeam;

import java.util.ArrayList;

@Slf4j
public class TeamService implements ITeamService {
    private final ArrayList<Match> arrayOfMatches = new ArrayList<>();

    private final ICreateService createService = new CreateService();
    private final ISummaryService summaryService = new SummaryService();
    private final ValidateTeam validateTeam = new ValidateTeam();

    public boolean create(Team homeTeam, Team awayTeam) {
        try {
            this.validateTeam.validateTeam(homeTeam, awayTeam);

            return this.arrayOfMatches.add(this.createService.create(homeTeam, awayTeam));
        } catch (IllegalArgumentException e) {
            log.error("Team names cannot be null or empty: homeTeam is {}, awayTeam is {}",
                    homeTeam.getName(),
                    awayTeam.getName());
        }
        return false;
    }

    public ArrayList<Match> summary() {
        return this.summaryService.summary((ArrayList<Match>) arrayOfMatches.clone());
    }
}
