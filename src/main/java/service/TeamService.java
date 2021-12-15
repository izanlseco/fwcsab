package service;

import lombok.extern.slf4j.Slf4j;
import model.Match;
import model.Team;
import util.ValidateTeam;

import java.util.ArrayList;

@Slf4j
public class TeamService implements ITeamService {
    private final ArrayList<Match> arrayOfMatch = new ArrayList<>();

    private final ICreateService createService = new CreateService();
    private final ISummaryService summaryService = new SummaryService();
    private final ValidateTeam validateTeam = new ValidateTeam();

    public void create(Team homeTeam, Team awayTeam) {
        try {
            this.validateTeam.validateTeam(homeTeam, awayTeam);

            this.arrayOfMatch.add(this.createService.create(homeTeam, awayTeam));
        } catch (IllegalArgumentException e) {
            log.error("There was the following error while validating the team: {}",
                    e.getMessage());
        }
    }

    public ArrayList<Match> summary() {
        return this.summaryService.summary(new ArrayList<>(arrayOfMatch));
    }
}
