package team.service;

import team.model.Match;
import team.util.SummaryHelper;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SummaryService implements ISummaryService {
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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
