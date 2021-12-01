package team.service;

import team.model.Match;

import java.util.ArrayList;

public interface ISummaryService {
    ArrayList<Match> summary(ArrayList<Match> matchSummary);
}
