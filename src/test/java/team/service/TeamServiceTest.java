package team.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import team.model.Match;
import team.model.Team;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class TeamServiceTest {

    private final static int FIRST_INDEX = 0;
    private final static int LAST_INDEX = 5;
    private TeamService teamService;

    @BeforeEach
    public void init() {
        this.teamService = new TeamService();
    }

    @Test
    public void whenNameIsNullIllegalArgumentExceptionIsThrown() {
        Throwable thrown = catchThrowable(() ->
                this.teamService.create(new Team(null, 5), new Team("France", 1)));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown).hasMessageContaining("Team names cannot be null");
    }

    @Test
    public void whenNameIsEmptyIllegalArgumentExceptionIsThrown() {
        Throwable thrown = catchThrowable(() ->
                this.teamService.create(new Team("Spain", 5), new Team("", 1)));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown).hasMessageContaining("Team names cannot be empty");
    }

    @Test
    public void whenTeamIsCreatedTrueIsReturned() {
        boolean response = this.teamService.create(new Team("Spain", 5), new Team("France", 1));

        assertThat(response).isTrue();
    }

    @Test
    public void whenSummaryIsEmptyEmptyArrayIsReturned() {
        assertThat(this.teamService.summary()).extracting(ArrayList::isEmpty).isEqualTo(true);
    }

    @Test
    public void whenSummaryContainsOneMatchOneMatchIsReturned() {
        this.teamService.create(new Team("Egypt", 0), new Team("South Africa", 3));

        final ArrayList<Match> response = this.teamService.summary();

        assertThat(response.get(FIRST_INDEX))
                .extracting("homeTeam.name", "homeTeam.score", "awayTeam.name", "awayTeam.score")
                .contains("Egypt", 0, "South Africa", 3);
    }

    @Test
    public void whenSummaryContainsMultipleMatchOrderedArrayIsReturned() {
        this.teamService.create(new Team("Spain", 3), new Team("Germany", 5));
        this.teamService.create(new Team("USA", 2), new Team("Holland", 8));
        this.teamService.create(new Team("Denmark", 5), new Team("Italy", 3));
        this.teamService.create(new Team("Switzerland", 2), new Team("Romania", 2));
        this.teamService.create(new Team("Brazil", 5), new Team("Russia", 5));
        this.teamService.create(new Team("Portugal", 3), new Team("Ukraine", 5));

        final ArrayList<Match> response = this.teamService.summary();

        assertThat(response.get(FIRST_INDEX))
                .extracting("homeTeam.name", "homeTeam.score", "awayTeam.name", "awayTeam.score")
                .contains("Brazil", 5, "Russia", 5);
        assertThat(response.get(LAST_INDEX))
                .extracting("homeTeam.name", "homeTeam.score", "awayTeam.name", "awayTeam.score")
                .contains("Switzerland", 2, "Romania", 2);
    }
}
