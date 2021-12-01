package team.util;

import team.model.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

public class SummaryHelper {

    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void orderMatch(final ArrayList<Match> matchSummary) {
        Collections.reverse(matchSummary);
        matchSummary.sort(Comparator
                .comparingInt((Match match) ->
                        match.getHomeTeam().getScore() + match.getAwayTeam().getScore()
                ).reversed()
        );
    }

    public void printSummary(ArrayList<Match> matchSummary) {
        log.info("This is the summary of the matches");
        for(Match summaryOfMatch : matchSummary) {
            log.info(summaryOfMatch.getHomeTeam().getName() + " " + summaryOfMatch.getHomeTeam().getScore()
                    + " - "
                    + summaryOfMatch.getAwayTeam().getName() + " " + summaryOfMatch.getAwayTeam().getScore()
            );
        }
    }
}
