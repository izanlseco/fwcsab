package team.util;

import team.model.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SummaryHelper {
    public void orderMatch(final ArrayList<Match> matchSummary) {
        Collections.reverse(matchSummary);
        matchSummary.sort(Comparator
                .comparingInt((Match match) ->
                        match.getHomeTeam().getScore() + match.getAwayTeam().getScore()
                ).reversed()
        );
    }

    public void printSummary(ArrayList<Match> matchSummary) {
        System.out.println("This is the summary of the matches");
        for(Match summaryOfMatch : matchSummary) {
            System.out.println(summaryOfMatch.getHomeTeam().getName() + " " + summaryOfMatch.getHomeTeam().getScore()
                    + " - "
                    + summaryOfMatch.getAwayTeam().getName() + " " + summaryOfMatch.getAwayTeam().getScore()
            );
        }
    }
}
