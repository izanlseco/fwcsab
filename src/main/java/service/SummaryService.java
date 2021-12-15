package team.service;

import lombok.extern.slf4j.Slf4j;
import team.model.Match;
import team.util.SummaryHelper;

import java.util.ArrayList;

@Slf4j
public class SummaryService implements ISummaryService {
    private final SummaryHelper summaryHelper = new SummaryHelper();

    public ArrayList<Match> summary(ArrayList<Match> matchSummary) {
        if (matchSummary.isEmpty()) {
            log.info("Team summary is empty");
            return matchSummary;
        }

        this.summaryHelper.orderMatch(matchSummary);
        this.summaryHelper.printSummary(matchSummary);

        return matchSummary;
    }

}
