package service;

import model.Match;
import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SummaryServiceTest {
    private final static int FIRST_INDEX = 0;
    private final static int SECOND_INDEX = 1;
    private final static int THIRD_INDEX = 2;
    private final static int FOURTH_INDEX = 3;
    private final static int FIFTH_INDEX = 4;
    private final static int SIXTH_INDEX = 5;
    private final static String HOME_TEAM_NAME = "homeTeam.name";
    private final static String HOME_TEAM_SCORE = "homeTeam.score";
    private final static String AWAY_TEAM_NAME = "awayTeam.name";
    private final static String AWAY_TEAM_SCORE = "awayTeam.score";
    private SummaryService summaryService;
    private ArrayList<Match> arrayOfMatchWithOneMatch;
    private ArrayList<Match> arrayOfMatchWithMultipleMatch;

    @BeforeEach
    public void init() {
        this.arrayOfMatchWithMultipleMatch = new ArrayList<>();
        this.arrayOfMatchWithOneMatch = new ArrayList<>();
        this.summaryService = new SummaryService();

        this.arrayOfMatchWithOneMatch.add(new Match(new Team("Egypt", 0), new Team("South Africa", 3)));

        this.arrayOfMatchWithMultipleMatch.add(new Match(new Team("Spain", 3), new Team("Germany", 5)));
        this.arrayOfMatchWithMultipleMatch.add(new Match(new Team("USA", 2), new Team("Holland", 8)));
        this.arrayOfMatchWithMultipleMatch.add(new Match(new Team("Denmark", 5), new Team("Italy", 3)));
        this.arrayOfMatchWithMultipleMatch.add(new Match(new Team("Switzerland", 2), new Team("Romania", 2)));
        this.arrayOfMatchWithMultipleMatch.add(new Match(new Team("Brazil", 5), new Team("Russia", 5)));
        this.arrayOfMatchWithMultipleMatch.add(new Match(new Team("Portugal", 3), new Team("Ukraine", 5)));
    }

    @Test
    public void whenSummaryContainsOneMatchThenOneMatchIsReturned() {
        final ArrayList<Match> response = this.summaryService.summary(this.arrayOfMatchWithOneMatch);

        assertThat(response.get(FIRST_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Egypt", 0, "South Africa", 3);
    }

    @Test
    public void whenSummaryContainsMultipleMatchThenOrderedArrayIsReturned() {
        final ArrayList<Match> response = this.summaryService.summary(arrayOfMatchWithMultipleMatch);

        assertThat(response.get(FIRST_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Brazil", 5, "Russia", 5);
        assertThat(response.get(SECOND_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("USA", 2, "Holland", 8);
        assertThat(response.get(THIRD_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Portugal", 3, "Ukraine", 5);
        assertThat(response.get(FOURTH_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Denmark", 5, "Italy", 3);
        assertThat(response.get(FIFTH_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Spain", 3, "Germany", 5);
        assertThat(response.get(SIXTH_INDEX))
                .extracting(HOME_TEAM_NAME, HOME_TEAM_SCORE, AWAY_TEAM_NAME, AWAY_TEAM_SCORE)
                .contains("Switzerland", 2, "Romania", 2);
    }
}
