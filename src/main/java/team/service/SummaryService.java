package team.service;

import team.model.Match;
import team.util.SummaryHelper;

import java.util.ArrayList;

public class SummaryService implements ISummaryService {

    private final SummaryHelper summaryHelper = new SummaryHelper();

    public ArrayList<Match> summary(ArrayList<Match> matchSummary) {
        if (matchSummary.isEmpty()) {
            System.out.println("Team summary is empty");
            return matchSummary;
        }

        this.summaryHelper.orderMatch(matchSummary);
        this.summaryHelper.printSummary(matchSummary);

        return matchSummary;
    }

}
