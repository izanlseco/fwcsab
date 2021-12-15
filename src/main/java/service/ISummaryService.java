package service;

import model.Match;

import java.util.ArrayList;

public interface ISummaryService {
    ArrayList<Match> summary(ArrayList<Match> matchSummary);
}
