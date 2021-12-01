package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Slf4j
public class SummaryService implements ISummaryService {

    public ArrayList<Match> summary(ArrayList<Match> matchSummary) {
        if (matchSummary.isEmpty()) {
            log.info("Team summary {} is empty", matchSummary);
            return matchSummary;
        }

        this.orderMatch(matchSummary);

        log.info("Ordered summary {}", matchSummary);

        return matchSummary;
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
