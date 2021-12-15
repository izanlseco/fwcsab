package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Match;
import model.Team;
import service.CreateService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateServiceTest {
    private final static String HOME_TEAM_NAME = "homeTeam.name";
    private final static String HOME_TEAM_SCORE = "homeTeam.score";
    private final static String AWAY_TEAM_NAME = "awayTeam.name";
    private final static String AWAY_TEAM_SCORE = "awayTeam.score";
    private CreateService createService;

    @BeforeEach
    public void init() {
        this.createService = new CreateService();
    }

    @Test
    public void whenNameIsNullThenMatchWithNullNameIsReturned() {
        Match response = this.createService.create(new Team(null, 5), new Team("France", 1));

        assertThat(response)
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains(null, 5, "France", 1);
    }

    @Test
    public void whenNameIsEmptyThenMatchWithEmptyNameIsReturned() {
        Match response = this.createService.create(new Team("Spain", 5), new Team("", 1));

        assertThat(response)
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Spain", 5, "", 1);
    }

    @Test
    public void whenTeamIsCreatedThenTeamIsReturned() {
        Match response = this.createService.create(new Team("Spain", 5), new Team("France", 1));

        assertThat(response)
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Spain", 5, "France", 1);
    }
}
